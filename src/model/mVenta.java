/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DARVIN
 */
public class mVenta {
    private int idven;
    private int idpro;
    private Double precom;
    private String fecven;
    private int canven;
    private Double preven;
    private int numval;

    public mVenta() {
    }

    public mVenta(int idven) {
        this.idven = idven;
    }

    public mVenta(int idpro, Double precom, String fecven, int canven, Double preven, int numval) {
        this.idpro = idpro;
        this.precom = precom;
        this.fecven = fecven;
        this.canven = canven;
        this.preven = preven;
        this.numval = numval;
    }

    public int getIdven() {
        return idven;
    }

    public void setIdven(int idven) {
        this.idven = idven;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public Double getPrecom() {
        return precom;
    }

    public void setPrecom(Double precom) {
        this.precom = precom;
    }

    public String getFecven() {
        return fecven;
    }

    public void setFecven(String fecven) {
        this.fecven = fecven;
    }

    public int getCanven() {
        return canven;
    }

    public void setCanven(int canven) {
        this.canven = canven;
    }

    public Double getPreven() {
        return preven;
    }

    public void setPreven(Double preven) {
        this.preven = preven;
    }

    public int getNumval() {
        return numval;
    }

    public void setNumval(int numval) {
        this.numval = numval;
    }
   
}
