/*
 * 06. 반복문. pdf No.19쪽 2번 문제 풀이
 * 문제 : 1부터 입력받은 값까지의 홀수 출력하는 프로그램 작성(단, 하나는  for반복문에서 1씩증가 해야 하고 반복문 안에서 if문과
 * %나머지 연산을 사용해야 한다. 또 다른 하나 for반복문은 2씩 증가해야 한다.
 */

import java.util.Scanner;

public class Ex06_02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 >>");
		int a = Integer.parseInt(scan.nextLine());
		
		//2씩 증가
		for(int i = 1; i <= a; i+=2) { // 어차피 1에서 2씩 증가면 홀수임
				System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println();
		
		System.out.print("숫자를 입력하세요 >>");
		int b = Integer.parseInt(scan.nextLine());
		
		//1씩 증가
		for(int i = 1; i <= b; i++) {
			if(i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
	}
}
