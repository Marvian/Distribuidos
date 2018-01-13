/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pan;

import java.io.Serializable;

/**
 *
 * @author gilbert
 */
public class Mensaje implements Serializable {

   private static final long serialVersionUID = 1113799434508676095L; 
   private Usuario usuario;
   private String ipVecino;
   private int puerto;
   private int[] byteParaEnvio;
   private boolean byteFinal;
   private int opcion;
   private String ipVecinoA; 
   
   public Mensaje () {
       this.usuario = null;
       this.ipVecino = null;
       this.puerto = 0;
       this.byteFinal = false;
       this.ipVecinoA = null;
   
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
    public String getIpVecinoS() {
        return ipVecino;
    }

    /**
     * @param ipVecino the ipVecino to set
     */
    public void setIpVecino(String ipVecinoS) {
        this.ipVecino = ipVecinoS;
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

    /**
     * @return the opcion
     */
    public int getOpcion() {
        return opcion;
    }

    /**
     * @param opcion the opcion to set
     */
    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    /**
     * @return the ipVecinoA
     */
    public String getIpVecinoA() {
        return ipVecinoA;
    }

    /**
     * @param ipVecinoA the ipVecinoA to set
     */
    public void setIpVecinoA(String ipVecinoA) {
        this.ipVecinoA = ipVecinoA;
    }
}
