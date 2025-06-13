/* java.io 패키지의 OutputStream API 특징)
 *  1.OutputStream 은 바이트 입력 스트림의 최상위 추상클래스이다.
 *  2.System.out은 모니터 출력장치와 연결됨
 */

import java.io.OutputStream;

public class IoEx02 {
	public static void main(String[] args) throws Exception{

		int data = 0;
		System.out.print("이름 입력>>");
		OutputStream myOut = System.out;
		
		while((data = System.in.read()) != -1) {
			myOut.write((char)data);
		}
	}
}
