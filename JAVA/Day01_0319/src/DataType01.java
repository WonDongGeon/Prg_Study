
public class DataType01 {
		/* public 키워드(예약어 : 약속된 명령어) 접근권한 제어자는 누구나 다 접근가능하게 한다.
		 * class 키워드는 클래스명을 정의할 때 사용한다.
		 */ 
	public static void main(String[] args) {
		/* static 키워드는 클래스명으로 직접접근하는 정적메서드를 정의할 때 사용한다.
		 * void 예약어는 반환값이 없는 타입이다, 즉 리턴타입이 없다.
		 * String[]은 문자열 배열이다.
		 */
		System.out.println(10); // System.out은 모니터 출력장치와 연결, print()는 출력해주는 메소드, ln은 줄바꿈
		System.out.println(10.5); // 10.5는 8바이트 double 실수 숫자값
		System.out.println('a'); // a는 단일문자 char 타입. 자바에서 단일문자는 해당 단일문자에 대한 십진수 정수로 저장
		System.out.println(true); // true or false는 조건판단할 때 사용하는 boolean 타입
		System.out.println(10L); // 10값 뒤에 접미사 1 or L이 붙으면 8바이트 long 타입 값
		System.out.println(10.3f); // 10.3값 뒤에 접미사 f or F가 붙으면 4바이트 float 타입 실수숫자 자료형
		System.out.println("seoul"); // "seoul"은 문자열 String 클래스형(기본타입이 아니고 레퍼런스 참조타입이다.)
		
		// 자바의 한줄 주석문
		/*
		 *  자바의 한 줄 이상 주석문 기호. 주석문이란 소스에 대한 설명문으로 실행되지 않는다.
		 */
	}

}
