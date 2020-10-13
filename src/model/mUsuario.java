/*
 La clase categoria va a contener 
 */
package model;

/**
 *
 * @author DARVIN
 */
public class mUsuario {
    //variables o campos de la clase categoria

    private int idusu;
    private String usuario;
    private String password;
    private String tipo;

    public mUsuario(int idusu, String usuario, String password, String tipo) {
        this.idusu = idusu;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
    }

    public mUsuario() {

    }

    public int getIdusu() {
        return idusu;
    }

    public void setIdusu(int idusu) {
        this.idusu = idusu;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
