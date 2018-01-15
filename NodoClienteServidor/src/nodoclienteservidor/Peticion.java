/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

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
			
			Socket socket = new Socket("192.168.43.48", 11000);
			
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
        
        
        mensaje.setOpcion(7);
        
        vecinoSig = LeerVecino();        
        
        Socket socket = new Socket( vecinoSig, 11000);
        
                if(mensaje.getIpPregunton() != socket.getInetAddress().getHostAddress()){
                    
                    if( mensaje.getIpPregunton() == null){
                        mensaje.setIpPregunton(socket.getInetAddress().getHostAddress());
                    }
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(mensaje);
			oos.flush();
                        
			Mensaje recibido = (Mensaje) ois.readObject();
                        
                        oos.close();
			ois.close();
                        
                }    
    
    }
    
    
    public static void BuscarRecurso(String nombre) {
    
        HiloBusquedaRecurso hiloBusquedaRecurso = new HiloBusquedaRecurso(nombre);
        hiloBusquedaRecurso.start();
        
    }
}
