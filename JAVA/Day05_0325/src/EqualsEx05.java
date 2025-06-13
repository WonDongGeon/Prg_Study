/* if 조건문(선택문) 형식)
 * 		if(조건식)
 * 			조건식이 참이면 실행;
 * 
 * 		실행문장이 한줄이상이면 반드시{} 중괄호 블록으로 묶어줘야 한다.
 */
// 음의 정수일 때 절대값을 구하는 프로그램

import java.util.Scanner;

public class EqualsEx05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("음의 정수 값만 입력 >> ");
		int num = scan.nextInt(); // 정수 숫자로 입력받음.
		
		if(num < 0)
			num = -num;
		System.out.println("절대값 = " + num);
		
	
	}

}
