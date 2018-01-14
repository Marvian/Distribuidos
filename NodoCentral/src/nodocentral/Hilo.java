/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodocentral;

import pan.Mensaje;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static nodocentral.JsonUsuario.usuarios;

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
        
        try {
            mensaje = (Mensaje)ois.readObject();
            System.out.println("NOMBRE" + mensaje.getOpcion());
            
            
            if(mensaje.getOpcion() == 1){
            	System.out.println("Un usuario "+this.sesionActual+" solicita registrarse");
            	System.out.println("Este es el usuario "+mensaje.getUsuario().getUsuario());
            	
            	try{
                    usuarios = JsonUsuario.Leer();
                    
	        }
	        
                catch(FileNotFoundException e){
                    System.out.println("Archivo vacio.");
                } 
                catch (IOException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (usuarios.isEmpty()){
                    mensaje.getUsuario().setDireccionIP(socket.getInetAddress().getHostAddress());
                    mensaje.getUsuario().setDireccionIPHash(HashIp.calcularHashIp(socket.getInetAddress().toString()));
                    usuarios.add(mensaje.getUsuario());
                    System.out.println(mensaje.getUsuario().getUsuario());
                    JsonUsuario.Escribir(usuarios);
                    oos.writeObject(mensaje);
                    oos.flush();
        	}
        	
                else {
                    int i = 0;
                    while ( i < usuarios.size()){
        		if ((usuarios.get(i).getUsuario().equals(mensaje.getUsuario().getUsuario())) || (usuarios.get(i).getClave().equals(mensaje.getUsuario().getClave()))){
                            break;
        		}
        		else{
                            i++;
        		}
                    }
                    
                    if (i == usuarios.size()){
                        usuarios.clear();
                        try{
                            usuarios = JsonUsuario.Leer();
                        } 

                        catch(FileNotFoundException e){
                            System.out.println("Archivo vacio.");
                        }	

                        mensaje.getUsuario().setDireccionIP(socket.getInetAddress().toString());
                        mensaje.getUsuario().setDireccionIPHash(HashIp.calcularHashIp(socket.getInetAddress().toString()));
                        usuarios.add(i, mensaje.getUsuario());
                        System.out.println("IP AGREGADO"+ mensaje.getUsuario().getDireccionIPHash() );
                        usuarios = JsonUsuario.OrdenarPorHash(usuarios);
                        JsonUsuario.Escribir(usuarios);	
                        oos.writeObject(mensaje);
                        oos.flush();
                    }
                }
            }
            
        }
        catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }   
    
    }
    
   
    
}
