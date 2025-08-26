package com.example.demo;
import java.net.*;
import java.io.*;

public class QRCodeHttpServer {

    public static void main(String[] args) throws Exception {
        int port = 9999;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버가 " + port + " 포트에서 대기 중입니다...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("클라이언트가 연결되었습니다: " + clientSocket.getInetAddress());

                    // HTTP 요청 헤더 읽기 (단순화된 예시)
                    BufferedReader in = 
                    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String line;
                    while ((line = in.readLine()) != null && !line.isEmpty()) {
                        System.out.println(line);
                    }

                    // QR 코드 이미지 생성
                    String qrData = "http://192.168.0.10:8080/attention?username=hongkildong";
                    int qrSize = 200;
                    String tempFilePath = "qrcode.png";
                    GenerateQRCode.generateQRCodeImage(qrData, qrSize, tempFilePath);

                    // 파일을 바이트 배열로 읽어오기
                    File qrFile = new File(tempFilePath);
                    byte[] imageBytes = new byte[(int) qrFile.length()];
                    try (FileInputStream fis = new FileInputStream(qrFile)) {
                        fis.read(imageBytes);
                    }

                    // HTTP 응답 헤더 작성
                    OutputStream out = clientSocket.getOutputStream();
                    PrintWriter writer = new PrintWriter(out, true);
                    // ln줄바뀜 : /r/n
                   
                    writer.println("HTTP/1.1 200 OK");
                    writer.println("Content-Type: image/png");
                    writer.println("Content-Length: " + imageBytes.length);
                    writer.println(); // 헤더와 본문을 구분하는 빈 줄
                    /*
                    writer.print("HTTP/1.1 200 OK\r\nContent-Type: image/png\r\nContent-Length: "
                    + imageBytes.length+"\r\n\r\n" );
                    */
                    // 이미지 바이트 배열 전송
                    out.write(imageBytes);
                    out.flush();

                    // 임시 파일 삭제
                    qrFile.delete();

                    System.out.println("QR 코드 이미지를 성공적으로 전송했습니다.");
                }
            }
        }
    }
    
    
}