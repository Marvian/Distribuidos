/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pan.Mensaje;
import pan.Usuario;

/**
 *
 * @author marvian
 */
public class Hilo extends Thread {
    
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private int sesionActual;
    private Mensaje mensaje;
    
    public Hilo(Socket socket, int sesionActual) {
        this.socket = socket;
        this.sesionActual = sesionActual;
        try {
        	ois = new ObjectInputStream(socket.getInputStream());
	        oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        try{
            System.out.println("LLEGO PETICION BITCH");
            mensaje = (Mensaje)ois.readObject();
            JsonVecinoSig.EscriboVecino(mensaje.getUsuario().getDireccionVecino());
            oos.writeObject(mensaje);
            oos.flush();
            oos.close();
            ois.close();
            socket.close();
                        
        
       
        
        
        
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
