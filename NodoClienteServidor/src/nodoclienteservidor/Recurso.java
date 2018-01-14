/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marvian
 */
public class Recurso implements Serializable {
    
    private String nombre;
    private String hashNombre;
    private long cantidad;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the hashNombre
     */
    public String getHashNombre() {
        return hashNombre;
    }

    /**
     * @param hashNombre the hashNombre to set
     */
    public void setHashNombre(String hashNombre) {
        this.hashNombre = hashNombre;
    }

    /**
     * @return the cantidadDescargas
     */
    public long getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidadDescargas the cantidadDescargas to set
     */
    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
    
    public static void obtenerRecursosEnDirectorio() {
        try {
            
            System.out.println("Pasa por aqui");
            final File baseDirectory = new File("");
            final File directory = new File(baseDirectory.getCanonicalPath() + File.separator + "client-node-music");
            final ArrayList<Recurso> resultList = new ArrayList();
            
            System.out.println(directory);

            for (File musicFile : directory.listFiles()) {
                final Recurso recurso = new Recurso();
                recurso.setNombre(musicFile.getName());
                recurso.setHashNombre(HashNombre.calcularHashNombre(musicFile.getName()));
                recurso.setCantidad(1);
                resultList.add(recurso);
            }

            JsonRecurso.EscribirRecursos(resultList);
        }
        catch (NoSuchAlgorithmException e) {
            System.err.println(e);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
