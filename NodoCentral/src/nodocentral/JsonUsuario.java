/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodocentral;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author marvian
 */
public class JsonUsuario {
    
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    public static ArrayList<Usuario> datosUsuarios(JSONObject usuarioJson){
	Usuario usuario = new Usuario();
	ArrayList<Usuario> usuarios = new ArrayList<>();
	usuario.setUsuario(((String) usuarioJson.get("Usuario")));
	usuario.setClave(((String) usuarioJson.get("Clave")));
	usuario.setDireccionIP(((String) usuarioJson.get("Direccion")));
	usuario.setCantidadDescargas(((Long) usuarioJson.get("Cantidad")));
	usuarios.add(usuario);
	return usuarios;
    }
    
    public static void Escribir(ArrayList<Usuario> listaUsuarios){
	File archivo = null;
		
	JSONObject usuariosJson = new JSONObject();
	JSONArray usuarios = new JSONArray();
            for (int i=0 ; i < listaUsuarios.size() ; i++){
		Usuario usuario = new Usuario();
		usuario.setUsuario(listaUsuarios.get(i).getUsuario());
		usuario.setClave(listaUsuarios.get(i).getClave());
		usuario.setDireccionIP(listaUsuarios.get(i).getDireccionIP());	
		JSONObject usuarioJson = new JSONObject();
		usuarioJson.put("Usuario",( listaUsuarios.get(i).getUsuario()));
		usuarioJson.put("Clave",(listaUsuarios.get(i).getClave()));
		usuarioJson.put("Direccion", (listaUsuarios.get(i).getDireccionIP()));
		usuarioJson.put("Cantidad",( listaUsuarios.get(i).getCantidadDescargas()));
		usuarios.add(usuarioJson);	
            }
            
            usuariosJson.put("Usuarios", usuarios);
            try{
			
		File miDir = new File (".");
		archivo = new File (miDir.getCanonicalPath()+"/Usuarios.Json");
			
		if (!archivo.exists())
                    archivo.createNewFile();
			
                    FileWriter fw = new FileWriter (archivo.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(usuariosJson.toJSONString());
                    bw.close();
		}
		catch (IOException e){		
		}	
	
	
	}
    
    public static ArrayList<Usuario> Leer() throws IOException{
		
	File archivo = null;
	JSONParser parseando = new JSONParser();
		
		
	try{
            File miDir = new File (".");
            archivo = new File (miDir.getCanonicalPath() +"/Usuarios.Json");
            FileInputStream fis = new FileInputStream(archivo);			 
            Object objeto = parseando.parse(new InputStreamReader(fis));	
            JSONObject objetoJson = (JSONObject) objeto;
            JSONArray arregloUsuarios = (JSONArray)objetoJson.get("Usuarios");;
            System.out.println("Tamaño Array LEYENDO: " + arregloUsuarios.size());
            usuarios.clear();
				
            try{   
                for (int i = 0; i < arregloUsuarios.size(); i++){
                JSONObject usuarioJson = (JSONObject)arregloUsuarios.get(i);
		usuarios.addAll(datosUsuarios(usuarioJson));
		System.out.println("Tamaño Array TERMINE DE LEER: " + usuarios.size());
		System.out.println(usuarios.get(i).getUsuario());
                }
                
                return usuarios;
            }
            
            catch(Exception e) {System.out.println(e);}
	    }
		
		
            catch(ParseException e){
		System.out.println("Ha ocurrido un error"+e.getMessage());
		System.out.println(e);
            }
            return usuarios;
		

	}
    
}
