/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodocentral;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import pan.Mensaje;

/**
 *
 * @author marvian
 */
public class Peticion {
    
    public static String ConoceVecino (Mensaje mensaje, String ip ){
        try { 
            Socket socket = new Socket(ip, 12000);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            mensaje.setOpcion(8);            
            oos.writeObject(mensaje);
            
            oos.flush();                       
            oos.close();
            ois.close();
            socket.close();
            return "Nuevo vecino";
        } 
        
        catch(Exception e1){
            return "error";
        }
    
    }
           
    
}
