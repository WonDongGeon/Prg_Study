/* 자바에서 + 연산 기호 특징)
 *  1. 숫자+숫자에서는 덧셈을 한다.
 *  2. 숫자+문자에서는 문자을 우선해서 숫자가 문자로 변경되어서 문자+문자 즉 문자를 연결한다.
 * 
 */
public class WeekEx03 {

	public static void main(String[] args) {
		int a =10;
		int b =10;
		int c = a+b; // 숫자+숫자는 덧셈을 한다.
		System.out.printf("%d + %d = %d%n", a, b, c); // %d는 10진수 정수 출력 형태
		
		String result = a + "10"; // 숫자+문자에서 문자를 우선해서 숫자가 문자로 변경되어 문자+문자 즉 "10"+"10" -> "1010"
		// 문자를 서로 연결한다.
		System.out.printf("result = %s\n", result); // %s는 문자열 출력 형태 지시자

	}

}
