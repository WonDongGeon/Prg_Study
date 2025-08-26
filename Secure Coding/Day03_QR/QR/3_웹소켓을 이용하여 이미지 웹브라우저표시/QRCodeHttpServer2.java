package com.example.demo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QRCodeHttpServer2 {

    private static final int PORT = 9999;

    public static void main(String[] args) throws Exception {
        // ExecutorService로 멀티스레딩 처리
        ExecutorService executorService = Executors.newCachedThreadPool();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("서버가 " + PORT + " 포트에서 대기 중입니다...");

            while (true) {
                // 클라이언트 연결 대기
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트가 연결되었습니다: " + clientSocket.getInetAddress());

                // 클라이언트 요청을 처리하는 스레드
                executorService.submit(() -> {
					try {
						handleClientRequest(clientSocket);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
            }
        }
    }

    private static void handleClientRequest(Socket clientSocket) throws Exception {
        try {
            // 클라이언트 요청 읽기 (헤더 출력)
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                System.out.println(line);  // 요청 헤더 출력
            }

            // QR 코드 생성
            String qrData = "http://192.168.0.10:8080/attention?username=hongkildong";
            int qrSize = 200;
            String tempFilePath = "qrcode.png";
            GenerateQRCode.generateQRCodeImage(qrData, qrSize, tempFilePath);

            // 파일을 바이트 배열로 읽기
            File qrFile = new File(tempFilePath);
            byte[] imageBytes = Files.readAllBytes(qrFile.toPath());

            // 클라이언트에게 HTTP 응답 헤더 전송
            OutputStream out = clientSocket.getOutputStream();
            String header = "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: image/png\r\n" +
                            "Content-Length: " + imageBytes.length + "\r\n" +
                            "Connection: close\r\n" +
                            "Cache-Control: no-cache\r\n\r\n";
            out.write(header.getBytes());

            // 이미지 데이터 전송 (버퍼링 방식으로)
            byte[] buffer = new byte[8192]; // 8KB 버퍼
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes)) {
                int bytesRead;
                while ((bytesRead = byteArrayInputStream.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }

            // 응답이 끝나면 소켓 종료
            out.flush();
            clientSocket.close();

            // 임시 파일 삭제
            qrFile.delete();

            System.out.println("QR 코드 이미지를 성공적으로 전송했습니다.");
        } catch (IOException e) {
            System.err.println("클라이언트 요청 처리 중 오류 발생: " + e.getMessage());
        }
    }
}
