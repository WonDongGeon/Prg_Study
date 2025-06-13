/* java.io 입출력 패키지의 Api인 InputStream,OutputStream를 활용해서 입력문자가 영문단일 소문자 'x'이거나 단일 대문자 'X'이면
 * while 반복문 종료한다.
 */

import java.io.InputStream;
import java.io.OutputStream;

public class IoEx03 {
	public static void main(String[] args) {

		int data = 0;
		InputStream myIn = System.in;
		OutputStream myOut = System.out;
		
		System.out.print("문자 입력>>");
		
		try {
			while((data = myIn.read()) != -1) {
				if(data == 'x' || data == 'X') {
					break;//반복문 종료
				}
				myOut.write((char)data);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
