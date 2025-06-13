/* 04장.연산자.pdf 1번 문제
 * 짝수인지 홀수인지 판단하는 프로그램을 삼한 조건연산자를 이용하여 작성하시오.
 */
public class Ex04_01 {

	public static void main(String[] args) {
		int a = 7;
		int b = 8;
		String result;
		
		result = a % 2 == 0 ? "짝수입니다." : "홀수입니다.";
		System.out.printf("%d는 %s%n",a, result);
		
		result = b % 2 == 0 ? "짝수입니다." : "홀수입니다.";
		System.out.printf("%d는 %s%n",b, result);
		
		
	}
}
