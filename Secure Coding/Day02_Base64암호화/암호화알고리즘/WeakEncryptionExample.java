package encode;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

//https://www.codeeeee.com/ko/encrypt/des.html
//https://www.base64decode.org/
//https://www.md5hashgenerator.com/
//https://crackstation.net/

public class WeakEncryptionExample {
    public static void main(String[] args) throws Exception {
    	 // DES 키 생성
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56); // 56비트 DES 키
        SecretKey key = keyGen.generateKey();

        // 키를 콘솔에 출력
        System.out.println("Generated DES Key (Base64 encoded): " + Base64.getEncoder().encodeToString(key.getEncoded()));
        
        // 암호화
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        String text = "mydata";
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
