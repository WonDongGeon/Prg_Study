/*
 * 06. 반복문. pdf No.18쪽 1번 문제 풀이
 * 문제 : 문자와 숫자를 입력받아 문자를 입력받은 숫자만큼 반복
 * 출력하시오.(Ex06_01.java -> for 반복문 사용) 
 */

import java.util.Scanner;

public class Ex06_01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자를 입력하세요 >> ");
		String s = scan.nextLine();
		System.out.print("숫자를 입력하세요 >> ");
		int a = Integer.parseInt(scan.nextLine());
		
		for(int i = 1; i <= a; i++) {
			System.out.println(s);
		}
		
	}

}
