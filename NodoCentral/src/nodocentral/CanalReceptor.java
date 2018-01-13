/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodocentral;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marvian
 */
public class CanalReceptor {
    
    public static void main (String args[]) {
    
        ServerSocket ss;
        System.out.println("Servidor Fantasma iniciado");
        
        try {
            ss = new ServerSocket(11000);
            System.out.println("\t[OK]");
            int idSession = 0;
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("Nuevo cliente: "+socket);
                ((Hilo) new Hilo(socket, idSession)).start();
                idSession++;
            }
        } 
        
        catch (IOException ex) {
            Logger.getLogger(CanalReceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }        
    
}
