/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author josue
 */
public class Hash {

    public String cifrarTexto(String texto) {
        MessageDigest messageDigest;
        String hash = "";

        try {
            messageDigest = MessageDigest.getInstance("SHA-256"); //"SHA-256";
            byte dataBytes[] = texto.getBytes(); // Texto a bytes
            messageDigest.update(dataBytes);
            byte resumen[] = messageDigest.digest(); // Se calcula el resumen
            System.out.println(new String(resumen) + " digest hash");
            hash = new String(resumen);
            hash = DatatypeConverter.printHexBinary(resumen).toLowerCase();
            System.out.println(hash + " hash hash");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash;
    }

}
