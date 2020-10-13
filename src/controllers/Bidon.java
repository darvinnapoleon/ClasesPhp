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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

 

    public boolean actualizar(mBidon sSql) {
        int cod = sSql.getIdcli();
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM bidon WHERE  idcli='" + cod + "'";
        try {

            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(5);
            }
        } catch (Exception e) {
        }

        desfinal = Integer.parseInt(cap) + sSql.getEstbid();
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

    public boolean actualizarbid(mBidon sSql) {
        int cod = sSql.getIdcli();
        int desfinal;
        desfinal = sSql.getEstbid() - 1;
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

    public boolean insbidon(mBidon sSql) {
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

    public boolean eliminar(mBidon sSql) {
        sql = "DELETE FROM bidon WHERE idbid = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, sSql.getIdbid());
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
    public boolean eliminar1(mBidon sSql) {
        sql = "DELETE FROM bidon WHERE idcli = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, sSql.getIdcli());
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
