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
import java.security.KeyPair;
import java.security.KeyPairGenerator;
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

import javax.crypto.spec.SecretKeySpec;
import javax.sound.sampled.AudioFormat;
import javax.xml.bind.DatatypeConverter;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author josue
 */
public class Cifrado {
    private static final String CLAVEPRIVADA= ResourceBundle.getBundle("cifrado.clavePrivada").getString("clave");
    private static final String CLAVEPUBLICA= ResourceBundle.getBundle("cifrado.clavePublica").getString("clave");
    private static final String CORREO= ResourceBundle.getBundle("cifrado.usuario").getString("correo");

    

    //private static final ResourceBundle configFile = ResourceBundle.getBundle("clave.properties");
    private static byte[] salt = "esta es la salt!".getBytes();
    private byte[] iv;
    private static String clave = "abcd*1234";

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
    public SecretKey  addKey(){
        byte[] valuebytes = clave.getBytes();            
       SecretKey key = new SecretKeySpec( Arrays.copyOf( valuebytes, 16 ) , "AES" );      
    return key;
    }
    
    public String cifrarTexto(String mensaje) {
                String value="";
        try {
            Cipher cipher;  
            cipher = Cipher.getInstance( "AES" );             
            cipher.init( Cipher.ENCRYPT_MODE, addKey() );             
            byte[] textobytes = mensaje.getBytes();
            byte[] cipherbytes = cipher.doFinal( textobytes );
            value = new BASE64Encoder().encode( cipherbytes );
        } catch (NoSuchAlgorithmException ex) {
            System.err.println( ex.getMessage() );
        } catch (NoSuchPaddingException ex) {
            System.err.println( ex.getMessage() );
        } catch (InvalidKeyException ex) {
            System.err.println( ex.getMessage() );
        } catch (IllegalBlockSizeException ex) {
            System.err.println( ex.getMessage() );
        } catch (BadPaddingException ex) {
            System.err.println( ex.getMessage() );
        }
        return value;
        

    }

    public String descifrarTexto(String mensaje) {
        String str="";        
        try {
                        Cipher cipher;  

            byte[] value = new BASE64Decoder().decodeBuffer(mensaje);                 
            cipher = Cipher.getInstance("AES");            
            cipher.init( Cipher.DECRYPT_MODE, addKey() );
            byte[] cipherbytes = cipher.doFinal( value );
            str = new String( cipherbytes );                                  
        } catch (InvalidKeyException ex) {
            System.err.println( ex.getMessage() );
        }  catch (IllegalBlockSizeException ex) {
            System.err.println( ex.getMessage() );
        } catch (BadPaddingException ex) {
            System.err.println( ex.getMessage() );            
        }   catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }catch (NoSuchAlgorithmException ex) {
            System.err.println( ex.getMessage() );
        } catch (NoSuchPaddingException ex) {
            System.err.println( ex.getMessage() );
        }
        return str;  
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
    public static PrivateKey leerClavePrivada() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
         PrivateKey pvKey = null;
        try {
            // Obtener los bytes del archivo donde este guardado la llave publica
            byte[] pvKeyBytes = hexStringToByteArray(CLAVEPRIVADA);
            //
            PKCS8EncodedKeySpec encPvKeySpec = new PKCS8EncodedKeySpec(pvKeyBytes);
            //
            pvKey = KeyFactory.getInstance("RSA").generatePrivate(encPvKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(Cifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pvKey;
    }
    public static PublicKey leerClavePublica() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] clavePu= hexStringToByteArray(CLAVEPUBLICA);
        X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(clavePu);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(publicSpec);
    }

   
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


    public String  cifrarTexto1(String mensaje) {
        byte[] encodedMessage = null;
        try {

            //Generamos una instancia de KeyFactory para el algoritmo RSA

            //Ciframos el mensaje con el algoritmo RSA modo ECB y padding PKCS1Padding
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, leerClavePublica());
            encodedMessage = cipher.doFinal(mensaje.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayToHexString(encodedMessage);
    }

    /**
     * Descifra un texto con RSA, modo ECB y padding PKCS1Padding (asim�trica) y
     * lo retorna
     *
     * @param mensaje El mensaje a descifrar
     * @return El mensaje descifrado
     */
    public String descifrarTexto1(String mensaje) {
        byte[] decodedMessage = null;
        byte[] contrasenia= hexStringToByteArray(mensaje);
        try {
            //Desciframos el mensaje con el algoritmo RSA modo ECB y padding PKCS1Padding
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, leerClavePrivada());
            decodedMessage = cipher.doFinal(contrasenia);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(decodedMessage);
    }

    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    

}
