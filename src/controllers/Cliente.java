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
import javax.naming.spi.DirStateFactory.Result;
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
    private String sql1 = "";
    private String sql2 = "";

    /* METODO DE TIPO PUBLIC QUE HA SIDO IMPORTADO DE UNA CLASE DE JAVA
     CUYO NOMBRE ES DATOS Y RECIBE UN VALOR DE TIPO STRING */
    public Date convert(String abc) {
        Date date1;
        try {
            date1 = new SimpleDateFormat("dd-MM-yyyy").parse(abc);
            return date1;
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public DefaultTableModel datos(String valor) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Apellidos", "Nombres", "Dni", "Fec.Emision", "Telefono"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM cliente WHERE apecli LIKE '%" + valor + "%' ORDER BY idcli DESC";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idcli");
                registro[1] = rs.getString("apecli");
                registro[2] = rs.getString("nomcli");
                registro[3] = rs.getString("dnicli");
                registro[4] = rs.getString("feccli");
                registro[5] = rs.getString("telcli");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel datos2(String valor) {
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

    public DefaultTableModel datoslocos(String valor) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Apellidos", "Nombres", "Dni", "Fec.Emision", "Telefono"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM cliente WHERE apecli LIKE '%" + valor + "%' ORDER BY idcli DESC";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idcli");
                registro[1] = rs.getString("apecli");
                registro[2] = rs.getString("nomcli");
                registro[3] = rs.getString("dnicli");
                registro[4] = rs.getString("feccli");
                registro[5] = rs.getString("telcli");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(mCliente sSql) {
        sql = "INSERT INTO cliente(apecli, nomcli, dnicli, feccli, telcli) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getApecli());
            pst.setString(2, sSql.getNomcli());
            pst.setString(3, sSql.getDnicli());
            pst.setString(4, sSql.getFeccli());
            pst.setString(5, sSql.getTelcli());
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

    public boolean actualizar(mCliente sSql) {
        //variable sql
        sql = "Update cliente SET apecli= ?, nomcli = ?, dnicli = ?, feccli = ?, telcli = ? WHERE idcli = ?";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getApecli());
            pst.setString(2, sSql.getNomcli());
            pst.setString(3, sSql.getDnicli());
            pst.setString(4, sSql.getFeccli());
            pst.setString(5, sSql.getTelcli());
            pst.setInt(6, sSql.getIdcli());
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

    public boolean eliminar(mCliente sSql) {
        sql = "DELETE FROM cliente WHERE idcli = ?";
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

    public String obtapenom(String txtdni) {
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

    public String obtacodcli(String txtdni) {
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

   

    public DefaultTableModel datosgas(String valor) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Fecha Vale", "Fecha Entrega", "Responsable"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT c.idcli, c.apecli, c.nomcli, dv.mesvale, dv.anovale, dv.fecdetval, dv.responsable FROM cliente AS c INNER JOIN detvale AS dv ON c.idcli=dv.idcli WHERE dv.estdetval=0 and c.dnicli='" + valor + "' ORDER BY dv.iddetval DESC";
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

    public DefaultTableModel datosvalmes(String valor) {
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
     public ArrayList<mValacu> Listar_Valfirmas(String valor1) {
        ArrayList<mValacu> list = new ArrayList<mValacu>();
       Date fec0 = new Date();
        Integer fec = fec0.getMonth() - 1;
        Integer ano = fec0.getYear() + 1900;
        sql = "SELECT dv.iddetval, c.apecli, c.nomcli, c.dnicli, dv.coddetval, dv.firma FROM cliente AS c INNER JOIN detvale AS dv ON c.idcli=dv.idcli WHERE dv.mesvale>='" + fec + "' and dv.anovale='" + ano + "' and c.dnicli='" + valor1 + "'";
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
                vo.setFir(rs.getInt(6));
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
