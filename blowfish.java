import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class BlowfishExample {

    public static void main(String[] args) throws Exception {
        
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128); // key length
        SecretKey secretKey = keyGenerator.generateKey();

        
        Cipher cipher = Cipher.getInstance("Blowfish");

        
        String plainText = "Hello, World!";

        
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        
        System.out.println("Encrypted: " + new String(encryptedBytes));

        
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        System.out.println("Decrypted: " + new String(decryptedBytes));
    }
}

