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
    
    public DefaultTableModel datos() {
        DefaultTableModel modelo;
        String[] titulos = {"Identificador", "Cod. Vale","Cliente", "Fecha", "Codcli", "Selec.."};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT c.idcli, c.apecli,c.nomcli, dv.iddetval, dv.coddetval, v.mesvale, v.anovale FROM cliente AS c "
                + "INNER JOIN detvale AS dv INNER JOIN vale AS v ON c.idcli = dv.idcli && dv.idvale = v.idvale WHERE dv.estdetval = 1 ORDER BY dv.iddetval ASC";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registro[0] = rs.getString("iddetval");
                registro[1] = rs.getString("coddetval");
                registro[2] = rs.getString("apecli")+" "+rs.getString("nomcli");
                registro[3] = rs.getString("mesvale")+"/"+rs.getString("anovale");
                registro[4] = rs.getString("idcli");
               
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
    public DefaultTableModel datnocan(mDetVal md) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "Apellidos y Nombres"};
        String[] registro = new String[2];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT  dv.iddetval, c.apecli,c.nomcli FROM cliente AS c "
                + "INNER JOIN detvale AS dv ON c.idcli = dv.idcli WHERE dv.mesvale ="+md.getMesvale()+" && dv.anovale = "+md.getAnovale()+" && dv.firma = 0 ORDER BY dv.iddetval ASC";
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
    public boolean insertar(mDetVal sSql) {
        sql = "INSERT INTO detvale(idcli,coddetval,estdetval,mesvale,anovale, fecdetval, responsable) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, sSql.getIdcli());
            pst.setString(2, sSql.getCoddetval());
            pst.setString(3, sSql.getEstdetval());
            pst.setInt(4, sSql.getMesvale());
            pst.setString(5, sSql.getAnovale());
            pst.setString(6, "");
            pst.setString(7, "");
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

   
    public ArrayList<mValacu> Listar_Valacumulado(String valor1){
        ArrayList<mValacu> list = new ArrayList<mValacu>();
        sql = "SELECT  dv.iddetval, c.apecli,c.nomcli, dv.mesvale, dv.anovale FROM cliente AS c "
                + "INNER JOIN detvale AS dv ON c.idcli = dv.idcli WHERE c.dnicli ='" + valor1 + "' and dv.estdetval = 1 and dv.firma = 1 ORDER BY dv.iddetval DESC";
        ResultSet rs = null;
        PreparedStatement ps = null;
      
        try{
             ps = (PreparedStatement) con.prepareStatement(sql);
          
            rs = ps.executeQuery();
            while(rs.next()){
                mValacu vo = new mValacu();
                vo.setIddetval(rs.getInt(1));
                vo.setApenom(rs.getString(2)+" "+rs.getString(3));
                vo.setFecvale(rs.getString(4)+"/"+rs.getString(5));
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
     public boolean actvalacu(mDetVal sSql) {
        //variable sql
        sql = "Update detvale SET fecdetval = ?, estdetval = ?, responsable = ?, firma = ? WHERE iddetval = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getFecdetval());
            pst.setString(2, sSql.getEstdetval());
            
            pst.setString(3, sSql.getResponsable());
            pst.setInt(4, sSql.getFirma());
            pst.setInt(5, sSql.getIddetval());
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
     public String vervale(mDetVal sSql) {
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
     public boolean actfir(mDetVal sSql) {
        //variable sql
        sql = "Update detvale SET firma= ? WHERE iddetval = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, sSql.getFirma());
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

     public boolean actvalpen(mDetVal sSql) {
        //variable sql
        sql = "Update detvale SET responsable = ?, fecdetval = ?, estdetval = ?, firma = ? WHERE iddetval = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getResponsable());
            pst.setString(2, sSql.getFecdetval());
            pst.setString(3, sSql.getEstdetval());
            pst.setInt(4, sSql.getFirma());
            pst.setInt(5, sSql.getIddetval());
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
}
