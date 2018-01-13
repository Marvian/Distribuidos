/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodocentral;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author marvian
 */
public class HashIp {
    
    public static String calcularHashIp (String direccionIP) throws NoSuchAlgorithmException {
            
            String hash = null;
            
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //Carga los valores al MessageDigest
            md5.update(direccionIP.getBytes());           
            // La direccionIp ya cifrada y lo pasa hexadecimal 
            StringBuilder sb = new StringBuilder();
            for (byte b : md5.digest())
                  sb.append(Integer.toHexString(0x100 + (b & 0xff)).substring(1));
            
            hash = sb.toString();

          return hash;
        }
    
}
