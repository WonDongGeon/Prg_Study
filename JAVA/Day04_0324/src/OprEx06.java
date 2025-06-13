// 산술 연산자
public class OprEx06 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 4;
		
		System.out.printf("%d + %d = %d%n", a, b, a+b);
		
		int result = a - b;
		System.out.println(a + " - " + b + " = " + result);
		
		System.out.printf("%d * %d = %d%n", a, b, a*b);
		
		System.out.printf("%d / %d = %d%n", a, b, a/b); // 정수 숫자를 나눗셈하면 몫만 구하고, 실수 숫자를 나눗셈하면 몫과 나머지를 함께 구한다. 
		
		/* 문제) int타입 b변수값을 float타입으로 형변환해서 나눗셈 한 결과값을 소수점 이하 6자리까지 printf()메소드를 사용해서
		 *  출력해보자
		 */
		//답안코드
		System.out.printf("%d / %f = %f%n", a, (float)b, a/(float)b); 
		
	}

}
