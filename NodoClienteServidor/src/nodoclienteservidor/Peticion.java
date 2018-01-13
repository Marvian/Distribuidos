/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import pan.Mensaje;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
			
			
			Socket socket = new Socket("localhost", 11000);
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(mensaje);
			oos.flush();
                        
			Mensaje recibido = (Mensaje) ois.readObject();
			
			oos.close();
			ois.close();
			
			return "Registrado";
		}
			catch(Exception e1){
				return "error";
			}
	}
    
    
    
}
