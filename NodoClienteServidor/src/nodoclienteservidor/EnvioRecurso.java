package nodoclienteservidor;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import pan.Mensaje;
import pan.Recurso;

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
    
    public static void cargandoRecurso(String nombreRecurso, ObjectOutputStream oos) throws FileNotFoundException, ParseException{
		File archivo = null;
		File miDir = new File (".");
		Mensaje envio = new Mensaje();
		int total = 0;
		try {
			archivo = new File (miDir.getCanonicalPath()+ File.separator + "client-node-music" + File.separator+ nombreRecurso);
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
			//contador comienza en 0, por eso sumo 1 para tener el total del archivo
                        total = contador + 1;
                        System.out.println("Valor total: " +total);
			envio.setOpcion(total);
			envio.setByteParaEnvio(bytesEntrada);
			System.out.println("Estoy enviando este array: " +envio.getByteParaEnvio());
                        ArrayList<Recurso> res = JsonRecurso.obtenerRecursosLocales();
                        for (int k = 0; k < res.size(); k++){
                            res.get(k).getNombre();
                            if ( res.get(k).getNombre() == nombreRecurso )
                                res.get(k).setCantidad(res.get(k).getCantidad()+1);
                        }
			oos.writeObject(envio);
			fis.close();
			fisDos.close();
			oos.close();
			JsonRecurso.EscribirRecursos(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
