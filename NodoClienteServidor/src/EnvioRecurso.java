
import java.io.File;
import java.io.FileInputStream;
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
    
   /* public void cargandoLibro(String nombreLibro, ObjectOutputStream oos){
		File archivo = null;
		File miDir = new File (".");
		Mensaje envio = new Mensaje();
		int total = 0;
		try {
			archivo = new File (miDir.getCanonicalPath()+"/"+nombreLibro+".pdf");
			@SuppressWarnings("resource")
			FileInputStream fis = new FileInputStream(archivo);
			FileInputStream fisDos = new FileInputStream(archivo);
			System.out.println("Direccion del archivo: " +miDir.getCanonicalPath()+"/"+nombreLibro+".pdf");
    			System.out.println("Lo que puedo cargar" +envio.getContenidoFichero());
			int contador = 0;
			while (!envio.isBytesFinales()){
				int bytesLeidos = fis.read();
				System.out.println(bytesLeidos);
				if (bytesLeidos == -1)
                    envio.setBytesFinales(true);
				contador++;
				
			}
			envio.setBytesFinales(false);
			int bytesEntrada[] = new int[contador];
			contador = 0;
			while (!envio.isBytesFinales()){
				int bytesLeidos = fisDos.read();
				if (bytesLeidos != -1){
					bytesEntrada[contador] = bytesLeidos;
					total = contador;
				}
				else{
					envio.setBytesFinales(true);
				}
				contador++;
			}
			System.out.println("Valor total: " +total);
			envio.setOpcion(total);
			envio.setContenidoFichero(bytesEntrada);
			System.out.println("Estoy enviando este array: " +envio.getContenidoFichero());
			oos.writeObject(envio);
			fis.close();
			fisDos.close();
			oos.close();
			
			long cantidad = LeerJson.LeerCantidadClientes();
			cantidad = cantidad + 1;
			EscribirJson.EscribirCantidad(cantidad);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
    
}
