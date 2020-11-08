/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.mCliente;
import model.mProducto;

/**
 *
 * @author DARVIN
 */
public class Com_Ven {

    private Conexion oconex = new Conexion();
    private Connection con = oconex.oConexion();
    private String sql = "";

    public ArrayList<mProducto> Lis_Pro(String valor) {
        ArrayList<mProducto> list = new ArrayList<mProducto>();
        sql = "SELECT idpro, nompro FROM producto ORDER BY nompro ASC";
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mProducto vo = new mProducto();
                vo.setIdpro(rs.getInt(1));
                vo.setNompro(rs.getString(2));
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
