/*
 La clase categoria va a contener 
 */
package model;

/**
 *
 * @author DARVIN
 */
public class mCliente {
    //variables o campos de la clase categoria

    private int idcli;
    private String apecli;
    private String nomcli;
    private String dnicli;
    private String telcli;

  

    public mCliente() {
    }

    public mCliente(int idcli, String apecli, String nomcli, String dnicli, String telcli) {
        this.idcli = idcli;
        this.apecli = apecli;
        this.nomcli = nomcli;
        this.dnicli = dnicli;
        this.telcli = telcli;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getApecli() {
        return apecli;
    }

    public void setApecli(String apecli) {
        this.apecli = apecli;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getDnicli() {
        return dnicli;
    }

    public void setDnicli(String dnicli) {
        this.dnicli = dnicli;
    }

    public String getTelcli() {
        return telcli;
    }

    public void setTelcli(String telcli) {
        this.telcli = telcli;
    }

   
}
