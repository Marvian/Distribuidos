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
import org.json.simple.JSONObject;

/**
 *
 * @author marvian
 */
public class EscribirJson {
    
        
    public static void EscribirRecurso(Recurso Recurso){
		File archivo = null;
		
		JSONObject recursosJson = new JSONObject();
		Recurso recurso = new Recurso();
		recurso.setNombre(Recurso.getNombre());
		recurso.setHashNombre(Recurso.getHashNombre());
		recurso.setCantidad(Recurso.getCantidad());	
		JSONObject recursoJson = new JSONObject();
		recursoJson.put("Nombre",(Recurso.getNombre()));
		recursoJson.put("HashNombre",(Recurso.getHashNombre()));
		recursoJson.put("Cantidad",(Recurso.getCantidad()));
				
		
		recursosJson.put("Recurso", recurso);
		try{
			
			File miDir = new File (".");
			archivo = new File (miDir.getCanonicalPath()+"/Recurso.Json");
			
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
