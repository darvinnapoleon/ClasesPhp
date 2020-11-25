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
public class mCaja {

    private int idcaj;
    private String feccaj;
    private Double micaj;
    private Double mfcaj;
    private Double movcaj;

    public mCaja() {
    }

    public mCaja(int idcaj, String feccaj, Double micaj, Double mfcaj, Double movcaj) {
        this.idcaj = idcaj;
        this.feccaj = feccaj;
        this.micaj = micaj;
        this.mfcaj = mfcaj;
        this.movcaj = movcaj;
    }

    public int getIdcaj() {
        return idcaj;
    }

    public void setIdcaj(int idcaj) {
        this.idcaj = idcaj;
    }

    public String getFeccaj() {
        return feccaj;
    }

    public void setFeccaj(String feccaj) {
        this.feccaj = feccaj;
    }

    public Double getMicaj() {
        return micaj;
    }

    public void setMicaj(Double micaj) {
        this.micaj = micaj;
    }

    public Double getMfcaj() {
        return mfcaj;
    }

    public void setMfcaj(Double mfcaj) {
        this.mfcaj = mfcaj;
    }

    public Double getMovcaj() {
        return movcaj;
    }

    public void setMovcaj(Double movcaj) {
        this.movcaj = movcaj;
    }
    

}
