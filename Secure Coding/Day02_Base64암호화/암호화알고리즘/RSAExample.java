package encode;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSAExample {

    // RSA 키 쌍 생성
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);  // 키 크기 (2048 비트)
        return keyPairGenerator.generateKeyPair();
    }

    // 데이터 암호화 (공개키 사용)
    public static String encrypt(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);  // 암호화된 데이터를 Base64로 인코딩하여 반환
    }

    // 데이터 복호화 (개인키 사용)
    public static String decrypt(String encryptedData, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);  // Base64로 디코딩된 데이터를 복호화
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);  // 복호화된 데이터를 문자열로 변환하여 반환
    }

    public static void main(String[] args) {
        try {
            // 키 쌍 생성
            KeyPair keyPair = generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // 암호화할 데이터
            String originalData = "Hello, RSA Encryption!";
            System.out.println("Original Data: " + originalData);

            // 데이터 암호화
            String encryptedData = encrypt(originalData, publicKey);
            System.out.println("Encrypted Data: " + encryptedData);

            // 데이터 복호화
            String decryptedData = decrypt(encryptedData, privateKey);
            System.out.println("Decrypted Data: " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
