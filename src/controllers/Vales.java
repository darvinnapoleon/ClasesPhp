/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.*;
import com.mysql.jdbc.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DARVIN
 */
/*esta es la clase qu8e nos permite realizar la busqueda de cualquier empleado para ello
cuenta con un objeto de conexion cuyo nombre es oconex y ademas */
public class Vales {

    private Conexion oconex = new Conexion();
    private Connection con = oconex.oConexion();
    private String sql = "";
    
    public DefaultTableModel no_can(mDetVal md) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "Apellidos y Nombres"};
        String[] registro = new String[2];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT  dv.iddetval, c.apecli,c.nomcli FROM cliente AS c "
                + "INNER JOIN detvale AS dv ON c.idcli = dv.idcli WHERE dv.mesvale ="+md.getMesvale()+" && dv.anovale = "+md.getAnovale()+" && dv.estdetval = 0 ORDER BY dv.iddetval ASC";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registro[0] = rs.getString("iddetval");
                registro[1] = rs.getString("apecli")+" "+rs.getString("nomcli");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    public boolean ins_detval(mDetVal sSql) {
        sql = "INSERT INTO detvale(idcli,coddetval,estdetval,mesvale,anovale, fecdetval, responsable) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, sSql.getIdcli());
            pst.setString(2, sSql.getCoddetval());
            pst.setString(3, sSql.getEstdetval());
            pst.setInt(4, sSql.getMesvale());
            pst.setString(5, sSql.getAnovale());
            pst.setString(6, "vacio");
            pst.setString(7, "vacio");
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

            return false;

        }
    }

   
    public ArrayList<mValacu> Lis_Valfir(String valor1){
        ArrayList<mValacu> list = new ArrayList<mValacu>();
        sql = "SELECT  dv.iddetval, dv.coddetval, dv.mesvale, dv.anovale FROM cliente AS c "
                + "INNER JOIN detvale AS dv ON c.idcli = dv.idcli WHERE c.dnicli ='" + valor1 + "' and dv.estdetval = 1  ORDER BY dv.iddetval DESC";
        ResultSet rs = null;
        PreparedStatement ps = null;
      
        try{
             ps = (PreparedStatement) con.prepareStatement(sql);
          
            rs = ps.executeQuery();
            while(rs.next()){
                mValacu vo = new mValacu();
                vo.setIddetval(rs.getInt(1));
                vo.setCod(rs.getString(2));
                vo.setFecvale(rs.getString(3)+"/"+rs.getString(4));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
    
            }catch(Exception ex){}
        }
        return list;
    }
     public boolean act_valfir(mDetVal sSql) {
        //variable sql
        sql = "Update detvale SET fecdetval = ?, estdetval = ?, responsable = ? WHERE iddetval = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getFecdetval());
            pst.setString(2, sSql.getEstdetval());
            pst.setString(3, sSql.getResponsable());
            pst.setInt(4, sSql.getIddetval());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

            return false;
        }
    }
     public String ver_vale(mDetVal sSql) {
        sql = "SELECT idcli FROM detvale where mesvale=? and anovale=? and idcli=?";
        String codcli = "";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, sSql.getMesvale());
            pst.setString(2, sSql.getAnovale());
            pst.setInt(3, sSql.getIdcli());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                codcli = rs.getString(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codcli;
    }
     public boolean act_valnofir(mDetVal sSql) {
        //variable sql
        sql = "Update detvale SET estdetval= ? WHERE iddetval = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getEstdetval());
            pst.setInt(2, sSql.getIddetval());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

            return false;
        }
    }

     public boolean act_valnocan(mDetVal sSql) {
        //variable sql
        sql = "Update detvale SET responsable = ?, fecdetval = ?, estdetval = ?WHERE iddetval = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getResponsable());
            pst.setString(2, sSql.getFecdetval());
            pst.setString(3, sSql.getEstdetval());
            pst.setInt(4, sSql.getIddetval());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

            return false;
        }
    }
     public int can_valcan() {
        sql = "SELECT COUNT(iddetval) FROM detvale where estdetval=1";
        int codcli=0;
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                codcli = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codcli;
    }
      public String rec_apenom(String txtdni) {
        String ape = "";
        String nom = "";
        sql = "SELECT * FROM cliente where dnicli= '" + txtdni + "'";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ape = rs.getString(2);
                nom = rs.getString(3);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ape + " " + nom;
    }
       public String rec_codcli(String txtdni) {
        String ape = "";

        sql = "SELECT * FROM cliente where dnicli= '" + txtdni + "'";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ape = rs.getString(1);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ape;
    }
       public DefaultTableModel val_ent(String valor) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Fecha Vale", "Fecha Entrega", "Responsable"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT c.idcli, c.apecli, c.nomcli, dv.mesvale, dv.anovale, dv.fecdetval, dv.responsable FROM cliente AS c INNER JOIN detvale AS dv ON c.idcli=dv.idcli WHERE dv.estdetval=2 and c.dnicli='" + valor + "' ORDER BY dv.iddetval DESC";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idcli");
                registro[1] = rs.getString("mesvale") + "/" + rs.getString("anovale");
                registro[2] = rs.getString("fecdetval");
                registro[3] = rs.getString("responsable");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
       public DefaultTableModel val_nofir(String valor) {
        DefaultTableModel modelo;
        String[] titulos = {"Apellidos y Nombres", "DNI", "Codigo",};
        String[] registro = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        Date fec0 = new Date();
        Integer fec = fec0.getMonth() - 1;
        Integer ano = fec0.getYear() + 1900;
        sql = "SELECT c.apecli, c.nomcli, c.dnicli, dv.coddetval FROM cliente AS c INNER JOIN detvale AS dv ON c.idcli=dv.idcli WHERE dv.mesvale='" + fec + "' and dv.anovale='" + ano + "' and dv.estdetval=1 and c.dnicli='" + valor + "'";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("apecli") + " " + rs.getString("nomcli");
                registro[1] = rs.getString("dnicli");
                registro[2] = rs.getString("coddetval");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
        public ArrayList<mValacu> Lis_valnofir(String valor1) {
        ArrayList<mValacu> list = new ArrayList<mValacu>();
       Date fec0 = new Date();
        Integer fec = fec0.getMonth() - 1;
        Integer ano = fec0.getYear() + 1900;
        sql = "SELECT dv.iddetval, c.apecli, c.nomcli, c.dnicli, dv.coddetval, dv.estdetval FROM cliente AS c INNER JOIN detvale AS dv ON c.idcli=dv.idcli WHERE dv.estdetval=0 and c.dnicli='" + valor1 + "'";
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                mValacu vo = new mValacu();
                vo.setIddetval(rs.getInt(1));
                vo.setApenom(rs.getString(2) + " " + rs.getString(3));
                vo.setDnicli(rs.getString(4));
                vo.setCod(rs.getString(5));
                vo.setEstdetval(rs.getString(6));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();

            } catch (Exception ex) {
            }
        }
        return list;
    }
}
