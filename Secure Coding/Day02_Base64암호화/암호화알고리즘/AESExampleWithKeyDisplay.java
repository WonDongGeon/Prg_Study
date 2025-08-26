package encode;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESExampleWithKeyDisplay {
    public static void main(String[] args) throws Exception {
        // AES 키 생성 (128비트 키)
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128비트 키
        SecretKey key = keyGen.generateKey();

        // 키를 콘솔에 출력
        System.out.println("Generated AES Key (Base64 encoded): " + Base64.getEncoder().encodeToString(key.getEncoded()));
        
        // 암호화
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        String text = "Sensitive data";
        byte[] encrypted = cipher.doFinal(text.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encrypted);

        System.out.println("Encrypted Text: " + encryptedText);

        // 복호화
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decrypted);

        System.out.println("Decrypted Text: " + decryptedText);
    }
}
