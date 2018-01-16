/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.FileOutputStream;
import java.io.IOException;
import pan.Mensaje;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import static nodoclienteservidor.JsonVecinoSig.LeerVecino;
import pan.Recurso;

/**
 *
 * @author marvian
 */
public class Peticion {
    
    public static String Regist(Mensaje mensaje){
        String Respuesta = null;
        
        return Respuesta;
    }
    
    public static String registro (Mensaje mensaje){
		try{
			
			Socket socket = new Socket("Localhost", 11000);

			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(mensaje);
			oos.flush();
                        
			Mensaje recibido = (Mensaje) ois.readObject();                        
                      
                        System.out.println("mi vecino" + recibido.getUsuario().getDireccionVecino());
			JsonVecinoSig.EscriboVecino(recibido.getUsuario().getDireccionVecino());
                        
                        String prueba = null;
                        System.out.println("ESTA VIVO" + JsonVecinoSig.LeerVecino());
                        
			oos.close();
			ois.close();
			
			return "Registrado";
		}
			catch(Exception e1){
				return "error";
			}
	}
    
    public static void BuscarEnVecinoRecurso (Mensaje mensaje) throws IOException, ClassNotFoundException{
        String vecinoSig = null;
        String array[] = null;
        System.out.println("entre en la peticion");
        
        
        mensaje.setOpcion(7);
        
        vecinoSig = LeerVecino();
        array = vecinoSig.split("/");
        
        System.out.println(vecinoSig);
        
        Socket socket = new Socket( vecinoSig, 12000);
        System.out.println("vecinoSig");
        
                if(mensaje.getIpPregunton() != socket.getInetAddress().getHostAddress()){
                    
                    if( mensaje.getIpPregunton() == null){
                        mensaje.setIpPregunton(socket.getInetAddress().getHostAddress());
                    }
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(mensaje);
			oos.flush();
                        
                        
                        FileOutputStream fos = new FileOutputStream(mensaje.getRecurso()+".pdf");
			Mensaje recibido = (Mensaje) ois.readObject();
			System.out.println("El nombre es: " + recibido.getRecurso());
			long hola = recibido.getOpcion();
			for (int i = 0; i < recibido.getByteParaEnvio().length-1; i++){ 
				fos.write(recibido.getByteParaEnvio()[i]);
				System.out.println("Van " + i + " de " + hola);
			}
                        
                        oos.close();
			ois.close();
                        
                }    
    
    }
    
    
    public static void BuscarRecurso(String nombre) {
    
        HiloBusquedaRecurso hiloBusquedaRecurso = new HiloBusquedaRecurso(nombre);
        hiloBusquedaRecurso.start();
        
    }
    
    public static String salida (Mensaje mensaje){
        try{
			
			Socket socket = new Socket("192.168.43.195", 11000);
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(mensaje);
			oos.flush();
                        
			Mensaje recibido = (Mensaje) ois.readObject();                        
                      
                        System.out.println("mi vecino" + recibido.getUsuario().getDireccionVecino());
			JsonVecinoSig.EscriboVecino(recibido.getUsuario().getDireccionVecino());
                        
                        String prueba = null;
                        System.out.println("ESTA VIVO" + JsonVecinoSig.LeerVecino());
                        
                        
                        
			oos.close();
			ois.close();
			
			return "Salida Exitosa";
		}
			catch(Exception e1){
				return "error";
			}
	}
    
    }
