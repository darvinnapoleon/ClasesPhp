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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mCaja;
import model.mCompra;
import model.mProducto;
import model.mVenta;
import validaciones.Fechas;

/**
 *
 * @author DARVIN
 */
public class Com_Ven {

    private Conexion oconex = new Conexion();
    private Connection con = oconex.oConexion();
    private String sql = "";
    mCaja mcaj = new mCaja();
    ArrayList<mCaja> liscaj = new ArrayList<mCaja>();
    ArrayList<mProducto> lispro = new ArrayList<mProducto>();
    mProducto mpro = new mProducto();
    Fechas fec = new Fechas();
    ResultSet rs = null;
    PreparedStatement ps = null;

    public ArrayList<mProducto> Lis_Pro(String valor) {
        sql = "SELECT p.idpro, p.nompro, dc.stopro, dc.precom, dc.iddc FROM producto AS p"
                + " INNER JOIN detcom AS dc ON p.idpro=dc.idpro WHERE dc.stopro>0 ORDER BY dc.iddc ASC";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mpro.setIdpro(rs.getInt(1));
                mpro.setNompro(rs.getString(2));
                mpro.setStopro(rs.getInt(3));
                mpro.setPre0(rs.getDouble(4));
                mpro.setIddc(rs.getInt(5));
                lispro.add(mpro);
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
        return lispro;
    }

    public ArrayList<mProducto> Lis_Procom(String valor) {
        sql = "SELECT p.idpro, p.nompro, p.stopro FROM producto AS p ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mpro.setIdpro(rs.getInt(1));
                mpro.setNompro(rs.getString(2));
                mpro.setStopro(rs.getInt(3));
                lispro.add(mpro);
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
        return lispro;
    }

    public boolean ins_caj(mCaja sSql) {
        sql = "INSERT INTO caja(feccaj, micaj, mfcaj, movcaj) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getFeccaj());
            pst.setDouble(2, sSql.getMicaj());
            pst.setDouble(3, sSql.getMfcaj());
            pst.setDouble(4, sSql.getMovcaj());
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

    public String ver_caj(mCaja sSql) {
        sql = "SELECT idcaj FROM caja where feccaj=?";
        String codcaj = "";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getFeccaj());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                codcaj = rs.getString(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(Com_Ven.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codcaj;
    }

    public ArrayList<mCaja> Dat_Caj(String valor1) {
        sql = "SELECT  * FROM caja WHERE feccaj ='" + valor1 + "' ORDER BY idcaj DESC";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mcaj.setIdcaj(rs.getInt(1));
                mcaj.setFeccaj(rs.getString(2));
                mcaj.setMicaj(rs.getDouble(3));
                mcaj.setMfcaj(rs.getDouble(4));
                mcaj.setMovcaj(rs.getDouble(5));
                liscaj.add(mcaj);
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
        return liscaj;
    }

    public boolean aum_mfcaj(mCaja sSql) {
        String cap = "";
        double desfinal;

        String consul = "SELECT mfcaj FROM caja WHERE  feccaj='" + fec.fec_act() + "'";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
        } catch (Exception e) {
        }

        desfinal = Double.parseDouble(cap) + (sSql.getMfcaj());
        String modi = "UPDATE caja SET  mfcaj='" + desfinal + "' WHERE feccaj = '" + fec.fec_act() + "'";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return true;
    }

    public boolean aum_movcaj(mCaja sSql) {
        double desfinal;
        desfinal = sSql.getMfcaj() - (sSql.getMicaj());
        String modi = "UPDATE caja SET  movcaj='" + desfinal + "' WHERE feccaj = '" + fec.fec_act() + "'";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return true;
    }

    public boolean ins_ven(mVenta sSql) {
        sql = "INSERT INTO ventas(idpro, fecven, canven, preven, numval, precom) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, sSql.getIdpro());
            pst.setString(2, sSql.getFecven());
            pst.setInt(3, sSql.getCanven());
            pst.setDouble(4, sSql.getPreven());
            pst.setInt(5, sSql.getNumval());
            pst.setDouble(6, sSql.getPrecom());
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

    public boolean disstock(mVenta sSql) {
        String cap = "";
        int desfinal;

        String consul = "SELECT stopro FROM producto WHERE  idpro='" + sSql.getIdpro() + "'";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
        } catch (Exception e) {
        }

        desfinal = Integer.parseInt(cap) - (sSql.getCanven());
        String modi = "UPDATE producto SET  stopro='" + desfinal + "' WHERE idpro = '" + sSql.getIdpro() + "'";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return true;
    }

    public boolean disstodc(mCompra sSql, int canven) {
        String cap = "";
        int desfinal;

        String consul = "SELECT stopro FROM detcom WHERE  iddc='" + sSql.getIddc() + "'";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
        } catch (Exception e) {
        }

        desfinal = Integer.parseInt(cap) - (canven);
        String modi = "UPDATE detcom SET  stopro='" + desfinal + "' WHERE iddc = '" + sSql.getIddc() + "'";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return true;
    }

    public boolean ins_com(mCompra sSql) {
        sql = "INSERT INTO compra(feccom, totcom) VALUES(?, ?)";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sSql.getFeccom());
            pst.setDouble(2, sSql.getTotcom());
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

    public boolean ins_detcom(mCompra sSql) {
        String maxid = "";
        String consul = "SELECT MAX(idcom)FROM compra";
        try {
            com.mysql.jdbc.Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                maxid = rs.getString(1);

            }
        } catch (Exception e) {
        }
        sql = "INSERT INTO detcom(idpro, idcom, precom, cancom, subcom, stopro) VALUES(?, ?, ?, ?, ?, ?)";
        int idd = Integer.parseInt(maxid);
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, sSql.getIdpro());
            pst.setInt(2, idd);
            pst.setDouble(3, sSql.getPrecom());
            pst.setInt(4, sSql.getCancom());
            pst.setDouble(5, sSql.getSubcom());
            pst.setInt(6, sSql.getStopro());
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

    public boolean aum_stock(mCompra sSql) {
        String cap = "";
        int desfinal;

        String consul = "SELECT stopro FROM producto WHERE  idpro='" + sSql.getIdpro() + "'";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
        } catch (Exception e) {
        }

        desfinal = Integer.parseInt(cap) + (sSql.getCancom());
        String modi = "UPDATE producto SET  stopro='" + desfinal + "' WHERE idpro = '" + sSql.getIdpro() + "'";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return true;
    }

    public boolean pro_precom(mCompra sSql) {
        String cap = "";
        Double desfinal;

        String consul = "SELECT pre0 FROM producto WHERE  idpro='" + sSql.getIdpro() + "'";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
        } catch (Exception e) {
        }

        desfinal = Math.rint((Double.parseDouble(cap) + (sSql.getPrecom())) / 2 * 100) / 100;
        String modi = "UPDATE producto SET  pre0='" + desfinal + "' WHERE idpro = '" + sSql.getIdpro() + "'";
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return true;
    }
}
