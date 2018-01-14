/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author marvian
 */
public class JsonRecurso {
    
        
    public static void EscribirRecursos(ArrayList<Recurso> recursos){
        File archivo = null;

        JSONObject recursosJson = new JSONObject();
        JSONArray recursosArray = new JSONArray();
        
        for(Recurso recurso : recursos) {
            JSONObject recursoJson = new JSONObject();
            recursoJson.put("Nombre",(recurso.getNombre()));
            recursoJson.put("HashNombre",(recurso.getHashNombre()));
            recursoJson.put("Cantidad",(recurso.getCantidad()));
        
            recursosArray.add(recursoJson);
        }
        
        recursosJson.put("Recursos", recursosArray);
        
        try{

                File miDir = new File ("");
                String path = miDir.getAbsolutePath() + File.separator + "Recurso.json";
                archivo = new File (path);

                if (!archivo.exists())
                        archivo.createNewFile();

                FileWriter fw = new FileWriter (archivo.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(recursosJson.toJSONString());
                bw.close();
        }
        catch (IOException e){	
            System.err.println(e);
        }	
    }
    
}
