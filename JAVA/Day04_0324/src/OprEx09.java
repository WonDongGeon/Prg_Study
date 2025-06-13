/* char 단일문자는 자바에서 십진수 정수로 저장된다. 이것을 활용한 연산예제  */
public class OprEx09 {

	public static void main(String[] args) {
		
		// ASCII코드
		char a = 'a'; // 'a'는 십진수 정수 97
		char d = 'd'; // 'd'는 십진수 정수 100
		char zero = '0'; // '0'은 십진수 정수 48
		char two = '2'; // '2'는 십진수 정수 50
				
		System.out.printf("'%c' - '%c' = %d\n", d, a, d-a ); // %c는 단일문자 출력형태, %d는 십진수 정수 출력형태, 100-97 = 3
		System.out.printf("'%c' - '%c' = %d\n", two, zero, two - zero); // 50 - 48 = 2
		System.out.printf("'%c' = %d\n", a, (int)a);
		System.out.printf("'%c' = %d\n", d, (int)d);
		System.out.printf("'%c' = %d\n", zero, (int)zero);
		System.out.printf("'%c' = %d\n", two, (int)two);
	}
}
