/* 입력받은 영문 단일문자가 대문자인지 소문자인지 판별하는 예제 */

import java.util.Scanner;

public class WeekEx07 {
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		char ch = ' '; // 단일문자 초기화는 반드시 한칸 띄어쓰기를 해야됨.
		System.out.print("영문 단일문자 입력 >> ");
		String result = scan.nextLine();
		ch = result.charAt(0); // charAt(0) 첫 단일문자를 구한다.
		
		String re = (ch >= 'A' && ch <= 'Z') ? "영문 대문자" : "영문 소문자" ;
		System.out.println("입력하신 문자 " + result + "는 " + re);
		
		
		

	}

}
