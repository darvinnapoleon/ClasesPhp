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
public class mDetVal {
    private int iddetval;
    private int idcli;
    private String coddetval;
    private String fecdetval;
    private String estdetval;
    private String responsable;
    private int mesvale;
    private String anovale;
    public mDetVal() {
    }

    public mDetVal(int iddetval, int idcli, String coddetval, String fecdetval, String estdetval, String responsable, int mesvale, String anovale) {
        this.iddetval = iddetval;
        this.idcli = idcli;
        this.coddetval = coddetval;
        this.fecdetval = fecdetval;
        this.estdetval = estdetval;
        this.responsable = responsable;
        this.mesvale = mesvale;
        this.anovale = anovale;
    }

    public int getIddetval() {
        return iddetval;
    }

    public void setIddetval(int iddetval) {
        this.iddetval = iddetval;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getCoddetval() {
        return coddetval;
    }

    public void setCoddetval(String coddetval) {
        this.coddetval = coddetval;
    }

    public String getFecdetval() {
        return fecdetval;
    }

    public void setFecdetval(String fecdetval) {
        this.fecdetval = fecdetval;
    }

    public String getEstdetval() {
        return estdetval;
    }

    public void setEstdetval(String estdetval) {
        this.estdetval = estdetval;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getMesvale() {
        return mesvale;
    }

    public void setMesvale(int mesvale) {
        this.mesvale = mesvale;
    }

    public String getAnovale() {
        return anovale;
    }

    public void setAnovale(String anovale) {
        this.anovale = anovale;
    }
    
}
