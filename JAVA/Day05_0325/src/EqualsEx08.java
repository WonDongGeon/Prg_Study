/* if(조건식 1) {
 * 		조건식 1이 참이면 실행;
 * } else if(조건식 2) {
 * 		조건식 2가 참이면 실행;
 * } else {
 * 		조건식 1,2가 거짓이면 실행;
 * }
 */

import java.util.Scanner;

public class EqualsEx08 {

	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		System.out.print("정수값 입력 >> ");
		int a = Integer.parseInt(scan.nextLine());
		
		if (a > 0) {
			System.out.println(a+"는 양수입니다.");
		} else if(a < 0) {
			System.out.println(a+"는 음수입니다.");
		} else {
			System.out.println("0입니다.");
		}
			
		
	}
}
