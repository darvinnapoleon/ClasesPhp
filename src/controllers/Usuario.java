/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.*;
import com.mysql.jdbc.*;
import java.sql.ResultSet;
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
public class Usuario {

    private Conexion oconex = new Conexion();
    private Connection con = oconex.oConexion();
    private String sql = "";

    /* METODO DE TIPO PUBLIC QUE HA SIDO IMPORTADO DE UNA CLASE DE JAVA
     CUYO NOMBRE ES DATOS Y RECIBE UN VALOR DE TIPO STRING */
    public DefaultTableModel datos(String valor) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Usuario", "Contraseña", "Tipo"};
        String[] registro = new String[4];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM usuario WHERE idusu LIKE '%" + valor + "%'";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registro[0] = rs.getString("idusu");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("password");
                registro[3] = rs.getString("tipo");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public String maxidven() {
        int j, cont = 1;
        String num = "", nummax = "";
        sql = "SELECT max(idusu) FROM usuario";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                nummax = rs.getString(1);
            }
        } catch (Exception ex) {
           // Logger.getLogger(nColaborador.class.getName()).log(Level.SEVERE, null, ex);

        }
        return nummax;

    }

    public boolean insertar(mUsuario sSql) {
        sql = "INSERT INTO usuario(usuario,password,tipo) VALUES(?,?,?)";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getUsuario());
            pst.setString(2, sSql.getPassword());
            pst.setString(3, sSql.getTipo());
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

    public boolean actualizar(mUsuario sSql) {
        //variable sql
        sql = "UPDATE usuario SET usuario=?, password = ?, tipo = ? WHERE idusu = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getUsuario());
            pst.setString(2, sSql.getPassword());
            pst.setString(3, sSql.getTipo());
            pst.setInt(4, sSql.getIdusu());
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

    public boolean eliminar(mUsuario sSql) {
        sql = "DELETE FROM usuario WHERE idusu = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, sSql.getIdusu());
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
