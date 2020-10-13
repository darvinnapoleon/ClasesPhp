/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.mUsuario;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DG15
 */
public class Logeo {

    private Conexion oconex = new Conexion();
    private Connection con = oconex.oConexion();
    private String sql = "";

    public boolean verifica(mUsuario sSql) {
        sql = "SELECT * FROM usuario where usuario=?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getUsuario());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                if (sSql.getPassword().equals(rs.getString(3))) {
                    sSql.setTipo(rs.getString(4));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;

        }

    }

}
