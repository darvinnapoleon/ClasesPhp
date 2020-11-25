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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Cliente {

    private Conexion oconex = new Conexion();
    private Connection con = oconex.oConexion();
    private String sql = "";

    /* METODO DE TIPO PUBLIC QUE HA SIDO IMPORTADO DE UNA CLASE DE JAVA
     CUYO NOMBRE ES DATOS Y RECIBE UN VALOR DE TIPO STRING */
    public ArrayList<mCliente> Lis_Cli(String valor){
        ArrayList<mCliente> list = new ArrayList<mCliente>();
            sql = "SELECT * FROM cliente WHERE apecli LIKE '%" + valor + "%' ORDER BY idcli DESC";
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
                vo.setDnicli(rs.getString(4));
                vo.setTelcli(rs.getString(5));
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

    public boolean ins_cli(mCliente sSql) {
        sql = "INSERT INTO cliente(apecli, nomcli, dnicli, telcli) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getApecli());
            pst.setString(2, sSql.getNomcli());
            pst.setString(3, sSql.getDnicli());
            pst.setString(4, sSql.getTelcli());
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

    public boolean act_cli(mCliente sSql) {
        //variable sql
        sql = "Update cliente SET apecli= ?, nomcli = ?, dnicli = ?, telcli = ? WHERE idcli = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getApecli());
            pst.setString(2, sSql.getNomcli());
            pst.setString(3, sSql.getDnicli());
            pst.setString(4, sSql.getTelcli());
            pst.setInt(5, sSql.getIdcli());
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

    public String verificadni(mCliente sSql) {
        sql = "SELECT * FROM cliente where dnicli=?";
        String dni = "";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getDnicli());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dni = rs.getString(4);
            }
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dni;
    }
 
}
