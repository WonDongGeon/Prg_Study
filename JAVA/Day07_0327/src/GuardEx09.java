// 스캐너와 이중 for 반복문 실습

import java.util.Scanner;

public class GuardEx09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("#을 출력할 라인 줄수를 입력 >>");
		int lineNumber = Integer.parseInt(scan.nextLine()); // 몇줄할건지 정하는 변수
		
		/* 문제) 이중 for 반복문을 활용한 #을 다음과 같이 출력되게 만들어 본다.
		 * 
		 */
		
		for(int i = 1; i <= lineNumber; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("# ");
			}
			System.out.println("");
		}
	}
}
