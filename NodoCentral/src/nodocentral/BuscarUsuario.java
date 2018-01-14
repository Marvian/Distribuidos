/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodocentral;

import java.io.IOException;
import java.util.ArrayList;
import pan.Usuario;

/**
 *
 * @author marvian
 */
public class BuscarUsuario {
    
     public static ArrayList<Usuario> leyendo(){
    	ArrayList<Usuario> auxiliar = new ArrayList<>();
    	try {
			auxiliar = JsonUsuario.Leer();
			System.out.println("Tamaño Array: " + auxiliar.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Archivo vacio.");
		}
    	return auxiliar;
    }
    
    public static Usuario buscarUsuario(String Hash){
	ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	listaUsuarios = leyendo();
	Usuario usuarioFinal = new Usuario();
	for (int i = 0; i < listaUsuarios.size(); i++){
		
            if ((listaUsuarios.get(i).getDireccionIPHash().equals(Hash))){
                
                if (i == 0){
                    usuarioFinal = listaUsuarios.get((listaUsuarios.size()-1));
                    System.out.println("Consegui al usuario en el archivo");
                    break;
                }
                
                else{
		usuarioFinal = listaUsuarios.get(i-1);
		System.out.println("Consegui al usuario en el archivo");
		break;
                }
            }
            else{
		usuarioFinal = null;
		System.out.println("No esta aun");
            }
	}
	
        System.out.println("ipVecino" + usuarioFinal.getDireccionIPHash());
	return usuarioFinal;
	
    }
    
}
