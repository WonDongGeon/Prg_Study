
/* java.io패키지의 InputStream API 특징)
 *  1.  InputStream은 바이트 입력스트림의 최상위 추상클래스이다.
 *  2.  System.in 은 키보드 입력장치와 연결된다.
 */

import java.io.IOException;
import java.io.InputStream;

public class IoEx01 {
	public static void main(String[] args) {

		int data = 0;
		System.out.print("문자 입력>>");
		
		try {
			InputStream myIn = System.in;
			
			while((data  = myIn.read()) != -1) {
				//read()메서드로 한 바이트씩 읽어들임. 스트림의 끝 즉 더 이상 읽을값이 없다면 -1
				System.out.write((char)data);
			}
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
