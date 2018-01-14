/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author genio
 */
public class HiloBusquedaRecurso extends Thread {

    private String _nombreRecurso;
    private Recurso _recurso;
    
    public HiloBusquedaRecurso( String nombreRecurso ) {
        _nombreRecurso = nombreRecurso;
    }
    
    public void run () {
        System.out.println("Buscando el recurso: " + _nombreRecurso);
        boolean conseguido = false;
        try {
            if (buscarRecursoLocal(_nombreRecurso)) {
                System.out.println("Recurso conseguido en el directorio local");
                File miDir = new File ("");
                String path = miDir.getAbsolutePath() + File.separator + "client-node-music";
                Download.downloadFileLocal(path, _nombreRecurso);
            } else {
                System.out.println("Buscando recurso en otro nodo");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private boolean buscarRecursoLocal(String nombre) throws IOException, FileNotFoundException, ParseException {
        boolean conseguido = false;
        
        ArrayList<Recurso> recursosLocales = JsonRecurso.obtenerRecursosLocales();
        for (Recurso recursoLocal : recursosLocales) {
            if (recursoLocal.getNombre().equals(nombre)) {
                conseguido = true;
                _recurso = recursoLocal;
            }
        }
        
        return conseguido;
    }
}
