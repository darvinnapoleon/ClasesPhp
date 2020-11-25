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
public class mCompra {
    private int idcom;
    private int iddc;
    private String feccom;
    private Double totcom;
    private int idpro;
    private Double precom;
    private int cancom;
    private Double subcom;
    private int stopro;

    public mCompra() {
    }

    public mCompra(int idcom, int iddc, String feccom, Double totcom, int idpro, Double precom, int cancom, Double subcom, int stopro) {
        this.idcom = idcom;
        this.iddc = iddc;
        this.feccom = feccom;
        this.totcom = totcom;
        this.idpro = idpro;
        this.precom = precom;
        this.cancom = cancom;
        this.subcom = subcom;
        this.stopro = stopro;
    }

    public int getIdcom() {
        return idcom;
    }

    public void setIdcom(int idcom) {
        this.idcom = idcom;
    }

    public int getIddc() {
        return iddc;
    }

    public void setIddc(int iddc) {
        this.iddc = iddc;
    }

    public String getFeccom() {
        return feccom;
    }

    public void setFeccom(String feccom) {
        this.feccom = feccom;
    }

    public Double getTotcom() {
        return totcom;
    }

    public void setTotcom(Double totcom) {
        this.totcom = totcom;
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

    public int getCancom() {
        return cancom;
    }

    public void setCancom(int cancom) {
        this.cancom = cancom;
    }

    public Double getSubcom() {
        return subcom;
    }

    public void setSubcom(Double subcom) {
        this.subcom = subcom;
    }

    public int getStopro() {
        return stopro;
    }

    public void setStopro(int stopro) {
        this.stopro = stopro;
    }
    
    
}
