/*
 *  www.naver.com 이라는 도메인을 가진 웹사이트 주소를 입력하면 이 주소에 대한 ip주소를 알아내는 소스)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException; 

public class NetWorkEx01 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader;
		String url = null;
		InetAddress addr = null; // InetAddress는 ip 번호를 처리할 때 사용하는 클래스
		
		reader = new BufferedReader(new InputStreamReader(System.in));
		/* 1. System.in은 키보드 입력장치와 연결됨.
		 *  2. InputStreamReader는 읽어드린 바이트 스트림을 문자 스트림으로 변경 (스트림은 데이터의 이동(통로))
		 *  3. BufferedReader는 읽어들인 문자를 임시메모리에 버퍼링한다. 한꺼번에 한줄 끝까지 문자열을 통으로 읽어들여서 효율적으로 읽어들임.
		 */
		System.out.print("사이트 주소를 입력(www.naver.com)");
		url = reader.readLine(); //한줄 끝까지 문자열로 읽어들임.
		
		try {
			addr = InetAddress.getByName(url); //인자값으로 지정된 url에 대한 InetAddress 객체를 반환
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n==================================\n");
		System.out.println(url + "에 대한 ip주소번호 = " + addr.getHostAddress());
		
	}
}
