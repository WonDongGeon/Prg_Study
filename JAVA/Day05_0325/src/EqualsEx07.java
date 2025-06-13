/* if ~ else 문을 활용한 최대값/최소값을 구하는 프로그램이다.  */

import java.util.Scanner;

public class EqualsEx07 {

	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.print("첫번째 정수값 입력>>");
			//int a = scan.nextInt(); // 정수 숫자로 입력 받음
			int a = Integer.parseInt(scan.nextLine()); // 문자열로 입력받은 것을 정수 숫자로 변경
			System.out.print("두번째 정수값 입력>>");
			String inputA = scan.nextLine(); // 문자열로 입력받음
			int b = Integer.parseInt(inputA); // 입력받은 문자를 정수 숫자로 변경
			
			int max = 0; // 최대값
			int min = 0; // 최소값
			
			if(a > b) {
				max = a;
				min = b;
			} else {
				max = b;
				min = a;
			}
				
			System.out.printf("최대값 = %d\n", max);
			System.out.printf("최소값 = %d\n", min);
			
	}

}
