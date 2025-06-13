/* if (조건식) {
 * 		조건식이 참이면 실행;
 * } else {
 * 		조건식이 거짓이면 실행;
 * }
 */

import java.util.Scanner;

public class EqualsEx06 {

	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.print("양의 정수값만 입력 >>");
			String inputA = scan.nextLine(); // 문자열로 입력받는다.
			int a = Integer.parseInt(inputA); // 입력받은 문자를 정수 숫자로 변경
			
			if (a > 0) {
				if(a % 2 == 0) {
					System.out.println(a+"는(은) 짝수이다.");
				} else {
					System.out.println(a+"는(은) 홀수이다.");
				}
			} else {
				System.out.println("양의 정수값만 입력하세요!");
			}
	}
}
