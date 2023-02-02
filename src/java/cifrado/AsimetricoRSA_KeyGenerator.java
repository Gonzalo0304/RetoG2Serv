package cifrado;

import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * <b>Criptograf�a Asim�trica (Clave p�blica) - Generador Claves</b> <br/>
 * <br/>
 * 
 * En un <b>Cifrado asim�trico</b> hay dos participantes: el emisor y el
 * receptor. Los pasos a seguir son:
 * 
 * <ul>
 * <li>Generar una <b>clave p�blica</b> y otra <b>privada</b>. La clave p�blica
 * se env�a al emisor</li>
 * <li>El emisor <u>cifra</u> los datos con <b>clave p�blica</b> y se env�an al
 * receptor</li>
 * <li>El receptor <u>descifra</u> los datos con <b>clave privada</b></li>
 * </ul>
 * 
 * En este caso, el algoritmo utilizado es el <b>RSA</b>. Para guardar una clave
 * en un archivo, se debe crear un <u>objeto de especificaci�n de clave</u>. La
 * clase para crear la especificaci�n de clave privada es
 * <u>PKCS8EncodedKeySpec</u>, y para la p�blica es <u>X509EncodedKeySpec</u>.
 */
public class AsimetricoRSA_KeyGenerator {

    /**
     * Genera el fichero con la clave privada
     */
    public void generatePrivateKey() {

        KeyPairGenerator generator;
        try {
            generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024); // Inicializamos el tama�o a 1024 bits
            KeyPair keypair = generator.genKeyPair();
            PublicKey publicKey = keypair.getPublic(); // Clave P�blica
            PrivateKey privateKey = keypair.getPrivate(); // Clave Privada

           
            FileOutputStream fileOutputStream = new FileOutputStream("Publica.properties");
            fileOutputStream.write(publicKey.getEncoded());
            fileOutputStream.close();

            // Privada
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
            fileOutputStream = new FileOutputStream("Privada.properties");
            fileOutputStream.write(pKCS8EncodedKeySpec.getEncoded());
            fileOutputStream.close();
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AsimetricoRSA_KeyGenerator asimetricoRSA_KeyGenerator = new AsimetricoRSA_KeyGenerator();
        asimetricoRSA_KeyGenerator.generatePrivateKey();
        System.out.println("Ficheros de Clave Generados!");
    }
}