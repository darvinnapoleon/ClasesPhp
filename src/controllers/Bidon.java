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
public class Bidon {

    private Conexion oconex = new Conexion();
    private Connection con = oconex.oConexion();
    private String sql = "";
    private String sql1 = "";
    
    public boolean enc_bid(mBidon sSql) {
        int cod = sSql.getIdcli();
        String cap = "";
        int desfinal;
        String consul = "SELECT estbid FROM bidon WHERE  idcli='" + cod + "'";
        try {

            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
        } catch (Exception e) {
        }

        desfinal = Integer.parseInt(cap) + sSql.getCanbid();
        String modi = "UPDATE bidon SET fecencbid=?, estbid=? WHERE idcli ='" + cod + "'";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(modi);
            pst.setString(1, sSql.getFecencbid());
            pst.setInt(2, desfinal);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return true;
    }

    public boolean rec_bid(mBidon sSql) {
        int cod = sSql.getIdcli();
        int desfinal;
        desfinal = sSql.getCanbid() - 1;
        sql = "UPDATE bidon SET fecalmbid=?, estbid=? WHERE idcli ='" + cod + "'";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getFecalmbid());
            pst.setInt(2, desfinal);
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

    public boolean ins_bid(mBidon sSql) {
        String cap = "";
        String consul = "SELECT MAX(idcli) FROM cliente";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            } 
        } catch (Exception e) {
           
        }
        sql = "INSERT INTO bidon(idcli) VALUES(?)";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            Bidon bid1 = new Bidon();
            int bid = Integer.parseInt(cap) + sSql.getIdcli()-1;
            pst.setInt(1, bid);
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
    public ArrayList<mCliente> Lis_Cli(String valor){
        ArrayList<mCliente> list = new ArrayList<mCliente>();
            sql = "SELECT  idcli, apecli, nomcli FROM cliente WHERE apecli LIKE '%" + valor + "%' ORDER BY idcli DESC";
        ResultSet rs = null;
        PreparedStatement ps = null;
      
        try{
             ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                mCliente vo = new mCliente();
                vo.setIdcli(rs.getInt(1));
                vo.setApecli(rs.getString(2));
                vo.setNomcli(rs.getString(3));
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
    public DefaultTableModel bid_enc(String valor) {
        Cliente cli = new Cliente();
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Apellidos", "Nombres", "Dni", "Can. Bidon(es)"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT c.idcli,c.apecli, c.nomcli,c.dnicli,b.estbid FROM cliente AS c INNER JOIN bidon AS b ON c.idcli=b.idcli WHERE apecli LIKE '%" + valor + "%' AND b.estbid > 0";
        Statement st;
        try {
            st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registro[0] = rs.getString("idcli");
                registro[1] = rs.getString("apecli");
                registro[2] = rs.getString("nomcli");
                registro[3] = rs.getString("dnicli");
                registro[4] = rs.getString("estbid");
                modelo.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
}
