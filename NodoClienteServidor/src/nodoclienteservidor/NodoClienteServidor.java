/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import pan.Usuario;
import pan.Mensaje;
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
        int respuesta = 0;
        String nombre;
        String contraseña;
        System.out.println("Inicando cliente");
        while ( respuesta != 9 ){
            
            System.out.println("1.- Registro");
            System.out.println("9.- Salir");

            respuesta = sc.nextInt();


            if (respuesta == 1 ){
                System.out.println("Insertar nombre");
                nombre = sc.next();
                
                Usuario usuario = new Usuario(nombre,null, null, null);
                Mensaje mensaje = new Mensaje();
                mensaje.setUsuario(usuario);
                mensaje.setOpcion(1);
                   System.out.println("Antes de registrar");
                if(Peticion.registro(mensaje).equals("Registrado")){
                    System.out.println("despues de registrar");
                   
                    System.out.println("Usuario registrado");
                    Recurso.obtenerRecursosEnDirectorio();
                    faseDos();
                }
                else{
                    System.out.println("Ese usuario ya existe");
                }
            }
        
        }
    }
    
    public static void faseDos(){
        
        Scanner sc = new Scanner(System.in);
        int respuesta2 = 0;
        
        while ( respuesta2 != 9 ){
        
            System.out.println("1.- Buscar Recurso");
            System.out.println("2.- Esta Solicitudes");
            System.out.println("3.- Recursos Ofrecidos");
            System.out.println("4.- Estado Respuestas");        
            System.out.println("5.- Numero de descargas por video");    
            System.out.println("9.- Salir"); 
        
            
            respuesta2 = sc.nextInt();
            
            if (respuesta2 == 1 ){
            }
            
            if (respuesta2 == 2 ){
            }
            
            if (respuesta2 == 3 ){
            }
            
            if (respuesta2 == 4 ){
            }
            
            if (respuesta2 == 5 ){
            }
            
            if (respuesta2 == 9 ){
            }
        }
        
    }
}
    

