/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author josue
 */
public class Cifrado {

    //private static final ResourceBundle configFile = ResourceBundle.getBundle("clave.properties");
    private static byte[] salt = "esta es la salt!".getBytes();
    private byte[] iv;
    private static String clave = "abcd1234";

    public String generarContra() {
        Mail mail = new Mail();
        String mensaje = aleatorioContraseña();
        return mensaje;
    }

    public String aleatorioContraseña() {
        int limitarIzq = 48; // numero '0'
        int limitarDrch = 90; // letra 'Z
        int objetivoStringLength = 8;
        String generadorString;
        char[] numero = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random aleatorio = new Random();
        do {
            generadorString = aleatorio.ints(limitarIzq, limitarDrch + 1).filter(i -> (i <= 57 || i >= 65)).limit(objetivoStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        } while (generadorString.contains(numero.toString()));

        return generadorString;

    }

    public String hashearMensaje(String mensaje) {
        Hash hash = new Hash();
        String hasheado = hash.cifrarTexto(mensaje);
        return hasheado;
    }

    public String cifrarTexto(String mensaje) {
              String ret = null;
        KeySpec keySpec = null;
        SecretKeyFactory secretKeyFactory = null;
        try {

            // Obtenemos el keySpec           
            keySpec = new PBEKeySpec(clave.toCharArray(), salt, 65536, 128); // AES-128

            // Obtenemos una instancide de SecretKeyFactory con el algoritmo "PBKDF2WithHmacSHA1"
            // Generamos la clave
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] key = secretKeyFactory.generateSecret(keySpec).getEncoded();

            // Creamos un SecretKey usando la clave + salt
            SecretKey privateKey = new SecretKeySpec(key, "AES");// AES;

            // Obtenemos una instancide de Cipher con el algoritmos que vamos a usar "AES/CBC/PKCS5Padding"
                    Cipher cipher= Cipher.getInstance("AES/CBC/PKCS5Padding");
                    
        // Iniciamos el Cipher en ENCRYPT_MODE y le pasamos la clave privada
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            // Le decimos que cifre (método doFinal())
            byte[] encodedMessage= cipher.doFinal(mensaje.getBytes());
// Obtenemos el vector CBC del Cipher (método getIV())
                    byte[] iv=cipher.getIV();
// Guardamos el mensaje codificado: IV (16 bytes) + Mensaje
                    byte[] combined = concatArrays(
            iv,encodedMessage);
            // Escribimos el fichero cifrado 
            //fileWriter("contra.properties", combined);

            // Retornamos el texto cifrado
            ret = new String(encodedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;

    }

        public String descifrarTexto(String fichero){
        String ret = null;

        // Fichero leído
        byte[] fileContent = fileReader(fichero); // Path del fichero EjemploAES.dat
        KeySpec keySpec = null;
        SecretKeyFactory secretKeyFactory = null;
        try {
            // Obtenemos el keySpec
            keySpec = new PBEKeySpec(clave.toCharArray(),salt,65536,128); // AES-128

            // Obtenemos una instancide de SecretKeyFactory con el algoritmo "PBKDF2WithHmacSHA1"
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            // Generamos la clave
            byte[] key = secretKeyFactory.generateSecret(keySpec).getEncoded();

            // Creamos un SecretKey usando la clave + salt
            SecretKey privateKey = new SecretKeySpec(key, "AES");

            // Obtenemos una instancide de Cipher con el algoritmos que vamos a usar "AES/CBC/PKCS5Padding"
            Cipher cipher= Cipher.getInstance("AES/CBC/PKCS5Padding");
            
            // Leemos el fichero codificado 
            IvParameterSpec ivParam = new IvParameterSpec(Arrays.copyOfRange(fileContent, 0, 16));
            // Iniciamos el Cipher en ENCRYPT_MODE y le pasamos la clave privada

            cipher.init(Cipher.DECRYPT_MODE,privateKey,ivParam);
            // Iniciamos el Cipher en ENCRYPT_MODE y le pasamos la clave privada y el ivParam
            // Le decimos que descifre
            byte[] decodedMessage = cipher.doFinal(Arrays.copyOfRange(fileContent, 16, fileContent.length));

            // Texto descifrado
            ret = new String(decodedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Retorna el contenido de un fichero
     *
     * @param path Path del fichero
     * @return El texto del fichero
     */
    private static byte[] fileReader(String path) {
        byte ret[] = null;
        File file = new File(path);
        try {
            ret = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Escribe un fichero
     *
     * @param path Path del fichero
     * @param text Texto a escibir
     */
    private void fileWriter(String path, byte[] text) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PublicKey leerClavePublica(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(fileReader(filename));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(publicSpec);
    }

  /**  public static PrivateKey leerClavePrivada() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        PrivateKey pvKey = null;
        try {
            // Obtener los bytes del archivo donde este guardado la llave publica
            byte[] pvKeyBytes = hexStringToByteArray(configFile.getString("PRIVATEKEY"));
            //
            PKCS8EncodedKeySpec encPvKeySpec = new PKCS8EncodedKeySpec(pvKeyBytes);
            //
            pvKey = KeyFactory.getInstance("RSA").generatePrivate(encPvKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(Cifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pvKey;
    }
*/
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
        /**
     * Retorna una concatenaci�n de ambos arrays
     *
     * @param array1
     * @param array2
     * @return Concatenaci�n de ambos arrays
     */
    private byte[] concatArrays(byte[] array1, byte[] array2) {
        byte[] ret = new byte[array1.length + array2.length];
        System.arraycopy(array1, 0, ret, 0, array1.length);
        System.arraycopy(array2, 0, ret, array1.length, array2.length);
        return ret;
    }
 
}
