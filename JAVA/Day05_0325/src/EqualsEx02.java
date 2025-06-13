/* &&(논리곱 : And), ||(논리합 : Or) 논리 연산자의 효율적인 연산에 관한 실습)
 * 1. || 논리합 연산에서 왼쪽 연산 결과가 true 이면 오른쪽 연산 결과가 true가 되든 false 되든 무조건 결과 연산값은 true가 된다.
 * 즉 왼쪽 연산 결과가 true가 되게 효율적인 코딩을 하면 오른쪽 연산은 수행하지 않아서 그만큼 실행속도가 빨라 진다.
 *
 * 2. && 논리곱 연산에서 왼쪽 연산 결과가 false 이면 오른쪽 연산 결과가 true가 되든 false가 되든 무조건 결과 연산값은 false가
 *된다. 즉 왼쪽 연산 결과를 false가 되게 효율적인 코딩을 하면 오른쪽 연산은 수행되지 않아서 프로그램 실행속도가 빨라진다.
 */
public class EqualsEx02 {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 0;
		
		System.out.printf("a = %d, b = %d%n", a, b); // %d는 10진수 정수 출력형태
		
		System.out.printf("a != 0 || ++b != 0 ? %b%n", a != 0 || ++b !=0); //true a!=0이 참이어서 ++b 선행증가 수행안했음.
		System.out.println("a = "+a+", b  = " + b); // 5, 0
		
		System.out.printf("a == 0 && ++b != 0 ? %b%n", a==0 && ++b != 0); // a == 0이 거짓이어서 ++b 선행증가 수행하지 않음.
		System.out.println("a = "+a+", b  = " + b); // 5, 0
		
	}

}
