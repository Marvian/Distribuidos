/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    
    public static ArrayList<Recurso> obtenerRecursosLocales() throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        ArrayList<Recurso> recursosLocales = new ArrayList<>();
        
        File miDir = new File ("");
        String path = miDir.getAbsolutePath() + File.separator + "Recurso.json";
        File archivo = new File (path);
        
        if (archivo.exists()){
            Object obj = parser.parse(new FileReader(archivo.getAbsoluteFile()));
            JSONObject recursosJSON = (JSONObject) obj;
            
            JSONArray recursos = (JSONArray) recursosJSON.get("Recursos");
            
            for (Object recurso : recursos) {
                JSONObject recursoObtenido = (JSONObject) recurso;
                
                Recurso nuevoRecurso = new Recurso();
                nuevoRecurso.setNombre((String) recursoObtenido.get("Nombre"));
                nuevoRecurso.setHashNombre((String) recursoObtenido.get("HashNombre"));
                nuevoRecurso.setCantidad((long) recursoObtenido.get("Cantidad"));
                
                recursosLocales.add(nuevoRecurso);
            }
        }
     
        return recursosLocales;
    }
    
}
