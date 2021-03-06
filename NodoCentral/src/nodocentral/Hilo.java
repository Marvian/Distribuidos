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
        Usuario vecinoSig = new Usuario();
        Usuario vecinoAnt = new Usuario();
        
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
        		if ((usuarios.get(i).getUsuario().equals(mensaje.getUsuario().getUsuario()))){
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
                        usuarios = JsonUsuario.OrdenarPorHash(usuarios);
                        JsonUsuario.Escribir(usuarios);	
                        vecinoSig = BuscarUsuario.buscarUsuarioSig(HashIp.calcularHashIp(socket.getInetAddress().toString()));
                        vecinoAnt = BuscarUsuario.buscarUsuarioAnt(HashIp.calcularHashIp(socket.getInetAddress().toString()));
                        
                        mensaje.getUsuario().setDireccionVecino(vecinoSig.getDireccionIP());
                        System.out.println("si lo trajo Sig" + vecinoSig.getDireccionIP());
                        System.out.println("si lo trajo ANT" + vecinoAnt.getDireccionIP());
                        
                        if (Peticion.ConoceVecino(mensaje, vecinoAnt.getDireccionIP()).equals("Nuevo vecino")){
                            System.out.println("el vecinoAnt de " + mensaje.getUsuario().getUsuario() + "ya sabe quien es") ;
                        }
                        
                        oos.writeObject(mensaje);
                        oos.flush();
                    }
                }
            }
            
            if (mensaje.getOpcion() == 24) {
                System.out.println("AVISO");
                System.out.println("El usuario "+this.sesionActual+" saldrá del nodo");
            	//System.out.println("Este es el usuario "+mensaje.getUsuario().getUsuario());
            	
                //mensaje.getUsuario().setDireccionIP(socket.getInetAddress().toString());
                String IPact = socket.getInetAddress().toString();
                
                vecinoSig = BuscarUsuario.buscarUsuarioSig(HashIp.calcularHashIp(socket.getInetAddress().toString()));
                String IPsig = (socket.getInetAddress().toString());
                vecinoAnt = BuscarUsuario.buscarUsuarioAnt(HashIp.calcularHashIp(socket.getInetAddress().toString()));
                String IPant = (socket.getInetAddress().toString());    
                       
                mensaje.getUsuario().setDireccionVecino(vecinoSig.getDireccionIP());
                System.out.println("Vecino Siguiente" + vecinoSig.getDireccionIP());
                System.out.println("Vecino Anterior" + vecinoAnt.getDireccionIP());
                
                if (Peticion.ConoceVecino(mensaje, vecinoAnt.getDireccionIP()).equals("Nuevo vecino")){
                System.out.println("Se ha asignado la IP del vecino correctamente");
                }
                JsonUsuario.EliminarUsuario(IPact);
            }
            
            
            
        oos.close();
        ois.close();
        socket.close();    
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
