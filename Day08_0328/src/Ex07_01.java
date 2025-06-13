/*
 *  07장 제어문의 다양한 활용.pdf No.8 1번 문제
 *  문제) 22부터 76까지의 짝수의 개수와 그 합을 구하는 프로그램을 작성하시오.(일반 for문)
 *  힌트는 짝수의 개수를 구할때는 ++ 증가 연산자를 활용한다.
 *   단, 2씩 증가된 for반복문과 1씩 증가된 for 반복문 각각 사용한다. 
 *   특히 1씩 증가된 반복문 안에서는 if문과 나머지 연산 %를 사용해야 한다.
 */
public class Ex07_01 {

	public static void main(String[] args) {
		int sum = 0;
		int num = 0;
		
		for(int i = 22; i <= 76; i+=2) {
			sum += i;
			num++;
		}
		System.out.printf("짝수의 개수 = %d, 전체 합 = %d%n", num, sum);
		
		int sum2 = 0;
		int num2 = 0;
		
		for(int i = 22; i <= 76; i++) { // i는 지역변수이기 때문에 또 선언해도 문제 없음(이중, 삼중 for문이 아닌 이상)
			if(i % 2 == 0) {
				sum2 += i; // 전체 합
				num2++; // 개수
			}
		}
		System.out.printf("짝수의 개수 = %d, 전체 합 = %d%n", num2, sum2);
	}
}
