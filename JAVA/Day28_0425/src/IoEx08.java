/* java.io 패키지의 InputStreamReader와 BufferedReader API 특징)
 *   1. InputStreamReader는 읽어들인 바이트를 문자스트림으로 변환해준다.
 *   2. BufferedReader는 읽어들인 문자를 버퍼링(임시메모리에 저장) 했다가 저장된 문자를 한줄 끝까지 한꺼번에 효율적으로 읽어들인다. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IoEx08 {
	public static void main(String[] args) {

		String fileName;
		InputStreamReader myIn = new InputStreamReader(System.in);
		BufferedReader keyBr = new BufferedReader(myIn);
		
		try {
			System.out.print("파일 이름 입력>>");
			fileName = keyBr.readLine();//한줄끝까지 읽어들임.
			System.out.println(fileName);
		}catch(IOException ie) {ie.printStackTrace();}
		finally {
			try {
				if(keyBr != null) keyBr.close();
				if(myIn != null) myIn.close();
			}catch(Exception e) {e.printStackTrace();}
		}
	}
}
