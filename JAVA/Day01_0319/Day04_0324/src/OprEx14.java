/* 자바의 비교연산자 예제) */
public class OprEx14 {

	public static void main(String[] args) {
		System.out.printf("10 == 10.0f  \t  %b\n ", 10 == 10.0f); // \t는 탭키만큼 수평으로 띄운다
		// %b는 boolean 타입 출력형태 10 == 10.0f => 10.0f == 10.0f => true
		
		System.out.printf("'0' == 0 \t %b\n", '0' == 0); // '0'은 10진수 정수 48이다. 48 == 0 => false
		System.out.printf("'A' == 65 \t %b\n", 'A' == 65); // 'A'은 10진수 정수 65이다. 65 == 65 => true
		System.out.printf("'A' > 'B' \t %b\n",'A' > 'B'); // 'A'은 10진수 정수 65이고, 'B'는 10진수 정수 66이다. 65 > 66 => false
		System.out.printf("'A' + 1 ! = 'B' \t %b\n", 'A' + 1 != 'B');  // 65 + 1 -> 66 != 66 => false
		
	}
}
