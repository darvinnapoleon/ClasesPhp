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
public class mProducto {
    private int idpro;
    private String nompro;
    private int stopro;
    private Double pre0;
    private Double pre1;
    private Double pre2;
    private Double pre3;
    private int iddc;
    public mProducto() {
    }

    public mProducto(int idpro, String nompro, int stopro, Double pre0, Double pre1, Double pre2, Double pre3, int iddc) {
        this.idpro = idpro;
        this.nompro = nompro;
        this.stopro = stopro;
        this.pre0 = pre0;
        this.pre1 = pre1;
        this.pre2 = pre2;
        this.pre3 = pre3;
        this.iddc = iddc;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getNompro() {
        return nompro;
    }

    public void setNompro(String nompro) {
        this.nompro = nompro;
    }

    public int getStopro() {
        return stopro;
    }

    public void setStopro(int stopro) {
        this.stopro = stopro;
    }

    public Double getPre0() {
        return pre0;
    }

    public void setPre0(Double pre0) {
        this.pre0 = pre0;
    }

    public Double getPre1() {
        return pre1;
    }

    public void setPre1(Double pre1) {
        this.pre1 = pre1;
    }

    public Double getPre2() {
        return pre2;
    }

    public void setPre2(Double pre2) {
        this.pre2 = pre2;
    }

    public Double getPre3() {
        return pre3;
    }

    public void setPre3(Double pre3) {
        this.pre3 = pre3;
    }

    public int getIddc() {
        return iddc;
    }

    public void setIddc(int iddc) {
        this.iddc = iddc;
    }
    
}
