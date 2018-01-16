/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;
import pan.Mensaje;
import pan.Recurso;
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
            mensaje = (Mensaje)ois.readObject();
            
            if(mensaje.getOpcion() == 8){
                
                System.out.println("IP de mi vecino siguiente"+ mensaje.getUsuario().getDireccionIP());
                JsonVecinoSig.EscriboVecino(mensaje.getUsuario().getDireccionIP());
                oos.writeObject(mensaje);
                oos.flush();
            }
            
            if(mensaje.getOpcion() == 7){                
                System.out.println("Esta buscando");
                boolean consiguio = false;
                
                ArrayList<Recurso> recursosLocales = JsonRecurso.obtenerRecursosLocales();
                for (Recurso recursoLocal : recursosLocales) {
                    if (recursoLocal.getNombre().equals(mensaje.getRecurso().getNombre())) {
                        
                        consiguio = true;
                        System.out.println(consiguio);
                        EnvioRecurso.cargandoRecurso(mensaje.getRecurso().getNombre(), oos);
                        break;
                    }
                
                    if(consiguio == true){
                    // crear hilo para la descarga
                    }
                }
                     
                
                //oos.writeObject(mensaje);
                
            
            }
            
                        
        
       
        oos.flush();
        oos.close();
        ois.close();
        socket.close();
        
        
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
