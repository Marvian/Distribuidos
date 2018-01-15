/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pan;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author marvian
 */
public class Recurso implements Serializable {
    
    private String nombre;
    private String hashNombre;
    private long cantidad;

    public Recurso(String nombre, String hashNombre, long  cantidad) {
		super();
		this.nombre = nombre;
		this.hashNombre = hashNombre;
		this.cantidad = cantidad;
	}

    public Recurso() {
         }

    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the hashNombre
     */
    public String getHashNombre() {
        return hashNombre;
    }

    /**
     * @param hashNombre the hashNombre to set
     */
    public void setHashNombre(String hashNombre) {
        this.hashNombre = hashNombre;
    }

    /**
     * @return the cantidadDescargas
     */
    public long getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidadDescargas the cantidadDescargas to set
     */
    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
}
