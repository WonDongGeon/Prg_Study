
public class DataType02 {
	/*  자바의 변수 선언법
	 *   타입 변수명;
	 *   변수를 선언하고 최초값을 지정하는 것을 변수 초기화라고 한다.
	 */ 
	public static void main(String[] args) {
		int age; //4바이트 int 타입 변수 age 선언
		age = 25; // age변수에 25값 대입(저장), =은 오른쪽 값을 왼쪽 변수에 저장하라는 대입(할당) 연산자이다.
		System.out.println("나이 : " + age); // +는 문자열 연결 연산기호
		
		age = 30; // 변수명 age에는 단 하나의 값만 저장할 수 있고, 마지막에 저장된 값만 남는다.
		System.out.println("나이 : " + age); // 30
	}
}
