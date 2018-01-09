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
    
        
    public static void Escribir(ArrayList<Recurso> listaRecursos){
		File archivo = null;
		
		JSONObject recursosJson = new JSONObject();
		JSONArray recursos = new JSONArray();
		for (int i=0 ; i < listaRecursos.size() ; i++){
			Recurso recurso = new Recurso();
			recurso.setNombre(listaRecursos.get(i).getNombre());
			recurso.setHashNombre(listaRecursos.get(i).getHashNombre());
			recurso.setCantidad(listaRecursos.get(i).getCantidad());	
			JSONObject recursoJson = new JSONObject();
			recursoJson.put("Nombre",( listaRecursos.get(i).getNombre()));
			recursoJson.put("HashNombre",(listaRecursos.get(i).getHashNombre()));
			recursoJson.put("Cantidad",( listaRecursos.get(i).getCantidad()));
			recursos.add(recursoJson);	
		}
		recursosJson.put("Recursos", recursos);
		try{
			
			File miDir = new File (".");
			archivo = new File (miDir.getCanonicalPath()+"/Usuarios.Json");
			
			if (!archivo.exists())
				archivo.createNewFile();
			
			FileWriter fw = new FileWriter (archivo.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(recursosJson.toJSONString());
			bw.close();
		}
		catch (IOException e){		
		}	
	
	
	}
    
}
