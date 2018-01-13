/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author marvian
 */
public class NodoClienteServidor {
    
    private int Respuesta;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        int respuesta;
        String nombre;
        String contraseña;
            
        System.out.println("1.- Iniciar sesion");
        System.out.println("2.- Registro");
        
        respuesta = sc.nextInt();
        
        System.out.println("Insertar nombre");
        nombre = sc.nextLine();
        System.out.println("Insertar contraseña");
        contraseña = sc.nextLine();
        
        Usuario usuario = new Usuario(nombre,contraseña, null, null);
        Mensaje mensaje = new Mensaje();
	mensaje.setUsuario(usuario);
        
        if (respuesta == 1 ){
            mensaje.setOpcion(1);
        }
        
        if (respuesta == 2 ){
            mensaje.setOpcion(2);
            
        }
        
    }
}
    

