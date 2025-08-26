package com.example.demo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRImage_mem {
	 public static void main(String[] args) throws Exception {
	        String data = "https://www.naver.com";
	        int size = 300;

	        // 파일을 생성하는 대신, 메모리에서 바로 화면에 표시
	        displayQRCodeImage(data, size);

	        // 이전 파일 저장 기능은 주석 처리 또는 삭제
	        // generateQRCodeImage(data, size, "qrcode.png");
	        // System.out.println("QR 코드가 생성되었습니다.");
	    }

	    // QR 코드를 생성하여 화면에 표시하는 메서드
	    public static void displayQRCodeImage(String data, int size) throws Exception {
	        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
	        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	        hints.put(EncodeHintType.MARGIN, 1);

	        MultiFormatWriter barcodeWriter = new MultiFormatWriter();
	        BitMatrix bitMatrix = barcodeWriter.encode(data, BarcodeFormat.QR_CODE, size, size, hints);

	        // BitMatrix를 BufferedImage로 변환
	        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
	        for (int x = 0; x < size; x++) {
	            for (int y = 0; y < size; y++) {
	                image.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
	            }
	        }

	        // GUI 창(JFrame)을 생성
	        JFrame frame = new JFrame("QR Code Display");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        // QR 코드 이미지를 표시할 라벨 생성
	        JLabel label = new JLabel(new ImageIcon(image));
	        
	        // 라벨을 창에 추가
	        frame.getContentPane().add(label);
	        
	        // 창 크기를 내용물에 맞게 조정하고 화면 중앙에 배치
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        
	        // 창을 보이게 설정
	        frame.setVisible(true);

	        System.out.println("QR 코드가 화면에 표시되었습니다.");
	    }
}
