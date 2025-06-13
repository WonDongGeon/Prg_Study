/*
 * 원본 이미지를 복사하는 예제
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class IoEx07 {
	public static void main(String[] args) throws IOException{

		Scanner scan = new Scanner(System.in);
		
		System.out.print("원본이미지 파일명(./src/images/flower.jpg)>>");
		String inputFileName = scan.nextLine();
		
		System.out.print("복사되어질 이미지 파일명(./src/images/flower_copy.jpg)>>");
		String outputFileName = scan.nextLine();
		
		try(InputStream inputStream = new FileInputStream(inputFileName);
				OutputStream outputStream = new FileOutputStream(outputFileName)){
			/* 자바 7버전에서 추가된 AutoCloseable 인터페이스를 상속받은 자손은 try()내에서 객체를 생성하면 굳이 finally문에서
			 * 명시적으로 해당객체를 close() 즉 닫지 않아도 자동을 닫힌다.
			 */
			int c;
			while((c = inputStream.read()) != -1) {
				outputStream.write(c);//파일에 기록
			}
		}//try
		
		System.out.println(inputFileName+"을(를) "+outputFileName+"으로 이미지를 복사했습니다.");
	}
}
