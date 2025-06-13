/* java.util 패키지에 있는 내장 API클래스 중에서 StringTokenizer는 특수문자를 기준으로 문자열을 분리해 준다. 분리된 문자를 토큰 문자라
 * 고 한다.
 * 주로 회원관리 프로그램에서 회원정보수정 창 등에서 활용된다.
 * 
 * StringTokenizer 한 방향으로만 순차적으로 토큰을 소비하기 때문에 한 번 nextToken()으로 꺼낸 토큰 문자는 다시 접근을 못한다.
 * 다시 사용하고 싶으면 StringTokenizer 객체를 새로 생성해야 한다.
 */

import java.util.StringTokenizer;

public class InterEx10 {
	public static void main(String[] args) {
		String phoneNumber ="010-7777-7777";
		
		StringTokenizer phone =new StringTokenizer(phoneNumber, "-"); // -를 기준으로 폰번호를 분리한다.
		String phone01 = phone.nextToken();
		String phone02 = phone.nextToken();
		String phone03 = phone.nextToken();
		System.out.println("첫번째 분리된 폰번호 : " + phone01);
		System.out.println("두번째 분리된 폰번호 : " + phone02);
		System.out.println("세번째 분리된 폰번호 : " + phone03);
		
		System.out.println("\n=======================\n");
		
		StringTokenizer phone2 = new StringTokenizer(phoneNumber, "-");
		
		while(phone2.hasMoreTokens()) { //분리된 토큰 문자가 있다면 참
			System.out.println(phone2.nextToken()); //분리된 문자(파싱된 문자)를 가져온다.
		}	
	}
}
