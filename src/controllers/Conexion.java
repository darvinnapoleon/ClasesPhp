/*
 esta es la clase de conexion la cual contiene los metodos y clases
 */
package controllers;

import com.mysql.jdbc.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DG15
 */
public class Conexion {

    //variables de la clase conexion
    public String bd = "gasroyer";//nombre de la BD
    public String cad = "jdbc:mysql://127.0.0.1/" + bd; //direccion del servidor(mysql).
    public String user = "root"; //usuario
    public String pass = "";//contraseña
    //constructor de la clase conexion

    public Connection oConexion() {
        Connection ocn = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            ocn = (Connection) DriverManager.getConnection(this.cad, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ocn;
    }

}
