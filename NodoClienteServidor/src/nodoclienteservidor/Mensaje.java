/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.Serializable;

/**
 *
 * @author marvian
 */
public class Mensaje implements Serializable {
    
   private Usuario usuario;
   private String ipVecino;
   private int puerto;
   private int[] byteParaEnvio;
   private boolean byteFinal;
   
   public Mensaje () {
       this.usuario = null;
       this.ipVecino = null;
       this.puerto = 0;
       this.byteFinal = false;
   
   }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the ipVecino
     */
    public String getIpVecino() {
        return ipVecino;
    }

    /**
     * @param ipVecino the ipVecino to set
     */
    public void setIpVecino(String ipVecino) {
        this.ipVecino = ipVecino;
    }

    /**
     * @return the puerto
     */
    public int getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    /**
     * @return the byteParaEnvio
     */
    public int[] getByteParaEnvio() {
        return byteParaEnvio;
    }

    /**
     * @param byteParaEnvio the byteParaEnvio to set
     */
    public void setByteParaEnvio(int[] byteParaEnvio) {
        this.byteParaEnvio = byteParaEnvio;
    }

    /**
     * @return the byteFinal
     */
    public boolean isByteFinal() {
        return byteFinal;
    }

    /**
     * @param byteFinal the byteFinal to set
     */
    public void setByteFinal(boolean byteFinal) {
        this.byteFinal = byteFinal;
    }
   
   
   
    
}
