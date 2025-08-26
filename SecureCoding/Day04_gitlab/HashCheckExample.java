package org.owasp.webgoat.vulnerable_components;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashCheckExample {

    // 문자열을 SHA-256 해시로 변환
    public static String getSHA256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());

            // 바이트 배열을 16진수 문자열로 변환
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // 테스트 및 검증
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 원본 문자열과 저장된 해시값 (예시)
        String original = "hello123";
        String storedHash = getSHA256Hash(original);
        System.out.println("저장된 해시: " + storedHash);

        // 사용자 입력
        System.out.print("비교할 문자열 입력: ");
        String userInput = scanner.nextLine();
        String inputHash = getSHA256Hash(userInput);

        // 해시 비교
        if (storedHash.equals(inputHash)) {
            System.out.println("✅ 일치합니다! (해시가 동일함)");
        } else {
            System.out.println("❌ 일치하지 않습니다. (해시 다름)");
        }

        scanner.close();
    }
}

