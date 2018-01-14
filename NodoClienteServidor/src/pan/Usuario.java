/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pan;

import java.io.Serializable;

/**
 *
 * @author marvian
 */
public class Usuario implements Serializable {
    
    private String usuario;
    private String clave;
    private String direccionIP;    
    private String direccionIPHash;
    private String direccionVecino;
    private long cantidadDescargas;
    
    public Usuario(String usuario, String clave, String correo, String direccionIP) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.direccionIP = direccionIP;
	}
	
	public Usuario(){
		this.usuario = "";
		this.clave = "";
		this.direccionIP = "";
		this.cantidadDescargas = 0;
	}

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the direccionIP
     */
    public String getDireccionIP() {
        return direccionIP;
    }

    /**
     * @param direccionIP the direccionIP to set
     */
    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    /**
     * @return the cantidadDescargas
     */
    public long getCantidadDescargas() {
        return cantidadDescargas;
    }

    /**
     * @param cantidadDescargas the cantidadDescargas to set
     */
    public void setCantidadDescargas(long cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    /**
     * @return the direccionIPHash
     */
    public String getDireccionIPHash() {
        return direccionIPHash;
    }

    /**
     * @param direccionIPHash the direccionIPHash to set
     */
    public void setDireccionIPHash(String direccionIPHash) {
        this.direccionIPHash = direccionIPHash;
    }

    /**
     * @return the direccionVecino
     */
    public String getDireccionVecino() {
        return direccionVecino;
    }

    /**
     * @param direccionVecino the direccionVecino to set
     */
    public void setDireccionVecino(String direccionVecino) {
        this.direccionVecino = direccionVecino;
    }
    
    
    
    
    
    
}
