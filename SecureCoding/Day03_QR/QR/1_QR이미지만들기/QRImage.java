package com.example.demo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRImage {
public static void main(String[] args) throws Exception {
	//파일로 생성
	//이미지를 화면에 바로 생성하는 방법
	//QR생성시 필요사항:data, 이미지크기, 이미지파일명
    generateQRCodeImage
    ("https://www.naver.com",300,"qrcode.png");
    System.out.println("QR 코드가 생성되었습니다.");
}

public static void generateQRCodeImage(String data, int size, String filePath) throws Exception {
    Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // 오류 수정 수준 설정
    hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // 문자 인코딩 설정
    hints.put(EncodeHintType.MARGIN, 1); // 여백 설정

    // QR 코드 생성
    MultiFormatWriter barcodeWriter = new MultiFormatWriter();
    BitMatrix bitMatrix = barcodeWriter.encode(data, BarcodeFormat.QR_CODE, size, size, hints);

    // BitMatrix를 이미지로 변환
    BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
    image.createGraphics();

    // QR 코드 이미지에 픽셀 색상 지정
    for (int x = 0; x < size; x++) {
        for (int y = 0; y < size; y++) {
            image.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
        }
    }

    // 이미지 파일로 저장
    File file = new File(filePath);
    ImageIO.write(image, "PNG", file);
}


}
