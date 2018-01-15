package nodoclienteservidor;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import pan.Mensaje;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marvian
 */
public class EnvioRecurso implements Serializable {
    
    public static void cargandoRecurso(String nombreRecurso, ObjectOutputStream oos){
		File archivo = null;
		File miDir = new File (".");
		Mensaje envio = new Mensaje();
		int total = 0;
		try {
			archivo = new File (miDir.getCanonicalPath()+"/client-node-music/"+nombreRecurso);
			@SuppressWarnings("resource")
			FileInputStream fis = new FileInputStream(archivo);
			FileInputStream fisDos = new FileInputStream(archivo);
			System.out.println("Direccion del archivo: " +miDir.getCanonicalPath()+"/"+nombreRecurso);
    			System.out.println("Lo que puedo cargar" +envio.getByteParaEnvio());
			int contador = 0;
			while (!envio.isByteFinal()){
				int bytesLeidos = fis.read();
				System.out.println(bytesLeidos);
				if (bytesLeidos == -1)
                    envio.setByteFinal(true);
				contador++;
				
			}
			envio.setByteFinal(false);
			int bytesEntrada[] = new int[contador];
			contador = 0;
			while (!envio.isByteFinal()){
				int bytesLeidos = fisDos.read();
				if (bytesLeidos != -1){
					bytesEntrada[contador] = bytesLeidos;
					total = contador;
				}
				else{
					envio.setByteFinal(true);
				}
				contador++;
			}
			System.out.println("Valor total: " +total);
			envio.setOpcion(total);
			envio.setByteParaEnvio(bytesEntrada);
			System.out.println("Estoy enviando este array: " +envio.getByteParaEnvio());
			oos.writeObject(envio);
			fis.close();
			fisDos.close();
			oos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
