/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author marvian
 */
public class JsonVecinoSig {
    
    
    public static void EscriboVecino (String Ip){
	File archivo = null;
		
	JSONObject JsonVecino = new JSONObject();
			
		JsonVecino.put("VecinoSig",(Ip));
            
           
            try{
			
		File miDir = new File (".");
		archivo = new File (miDir.getCanonicalPath()+"/VecinoSig.Json");
			
		if (!archivo.exists())
                    archivo.createNewFile();
			
                    FileWriter fw = new FileWriter (archivo.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(JsonVecino.toJSONString());
                    bw.close();
		}
		catch (IOException e){		
		}		
    }
    
     public static String LeerVecino() throws IOException{
		
	File archivo = null;
	JSONParser parseando = new JSONParser();
        String vecinoIp;
		
		
	try{
            File miDir = new File (".");
            archivo = new File (miDir.getCanonicalPath() +"/VecinoSig.Json");
            FileInputStream fis = new FileInputStream(archivo);			 
            Object objeto = parseando.parse(new InputStreamReader(fis));	
            JSONObject objetoJson = (JSONObject) objeto;
				
              
            vecinoIp = (String) objetoJson.get("VecinoSig");
                
                
                
                return vecinoIp;
            }
            
            catch(Exception e) {System.out.println(e);}
        
            return null;            
		

	}
    
}
