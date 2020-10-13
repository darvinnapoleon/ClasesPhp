/*
 La clase categoria va a contener 
 */
package model;

/**
 *
 * @author DARVIN
 */
public class mBidon {
    private int idbid;
    private int idcli;
    private String fecencbid;
    private String fecalmbid;
    private int estbid;

    public mBidon() {
    }

    public mBidon(int idbid, int idcli, String fecencbid, String fecalmbid, int estbid) {
        this.idbid = idbid;
        this.idcli = idcli;
        this.fecencbid = fecencbid;
        this.fecalmbid = fecalmbid;
        this.estbid = estbid;
    }

    public int getIdbid() {
        return idbid;
    }

    public void setIdbid(int idbid) {
        this.idbid = idbid;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getFecencbid() {
        return fecencbid;
    }

    public void setFecencbid(String fecencbid) {
        this.fecencbid = fecencbid;
    }

    public String getFecalmbid() {
        return fecalmbid;
    }

    public void setFecalmbid(String fecalmbid) {
        this.fecalmbid = fecalmbid;
    }

    public int getEstbid() {
        return estbid;
    }

    public void setEstbid(int estbid) {
        this.estbid = estbid;
    }

    
    
}
