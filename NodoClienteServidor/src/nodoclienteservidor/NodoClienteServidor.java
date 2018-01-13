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
        int respuesta = 0;
        String nombre;
        String contraseña;
        System.out.println("Inicando cliente");
        
        while ( respuesta != 9 ){
            
            System.out.println("1.- Iniciar sesion");
            System.out.println("2.- Registro");

            respuesta = sc.nextInt();


            if (respuesta == 1 ){
                System.out.println("Insertar nombre");
                nombre = sc.nextLine();
                System.out.println("Insertar contraseña");
                contraseña = sc.nextLine();
                
                System.out.println(nombre);                
                System.out.println(contraseña);

                Usuario usuario = new Usuario(nombre,contraseña, null, null);
                Mensaje mensaje = new Mensaje();
                mensaje.setUsuario(usuario);
                mensaje.setOpcion(1);

                    if(Peticion.registro(mensaje).equals("Registrado")){
                        System.out.println("Usuario registrado");
                    }

                    else{
                        System.out.println("Ese usuario ya existe");
                    }
            }

            if (respuesta == 2 ){

                System.out.println("Insertar nombre");
                nombre = sc.nextLine();
                System.out.println("Insertar contraseña");
                contraseña = sc.nextLine();

                Usuario usuario = new Usuario(nombre,contraseña, null, null);
                Mensaje mensaje = new Mensaje();
                mensaje.setUsuario(usuario);
                mensaje.setOpcion(2);

                    if(Peticion.registro(mensaje).equals("Sesion")){
                        System.out.println("Inicio de sesion");
                    }

                    else{
                        System.out.println("Datos equivocados");
                    }

            }
        
        }
    }
}
    

