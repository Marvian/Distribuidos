/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

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
    
    public static void Escuchando (){
        
        ServerSocket ss;
        System.out.println("Cliente/Servidor listo para crear hilos");
        
        try {
            ss = new ServerSocket(12000);
            System.out.println("\t[OK]");
            int idSession = 0;
            while (true) {
                System.out.println("PAN");
                Socket socket;
                socket = ss.accept();
                System.out.println("Nuevo nodo: "+socket);
                ((Hilo) new Hilo(socket, idSession)).start();
                idSession++;
            }
        } 
        
        catch (IOException ex) {
            Logger.getLogger(CanalReceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
