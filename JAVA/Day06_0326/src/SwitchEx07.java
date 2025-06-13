//if else if else 다중

import java.util.Scanner;

public class SwitchEx07 {

	public static void main(String[] args) {
		
		 Scanner scan = new Scanner(System.in);
		 System.out.print("1월부터 12월사이 월만 입력 >>");
		 int month = Integer.parseInt(scan.nextLine());
		 
		 if(!(month >= 1 && month <= 12)) {
			 System.out.println("1월 부터 12월 사이 월만 입력하세요!");
		 } else {
			 /* 문제) if else if 다중조건문과 논리합 || 을 사용해서 3월, 4월. 5월인 경우는 봄, 6월 이거나 7월이거나 8월이면 여름,
			  * 9월이거나 10월이거나 11월이면 가을, 나머지는 겨울을 구하는 프로그램 코드를 만들어 보자.
			  * 
			  */
			 if(month == 3 || month == 4 || month == 5 ) {
				 System.out.println("봄입니다.");
			 } else if (month == 6 || month == 7 || month == 8) {
				 System.out.println("여름입니다.");
			 } else if (month == 9 || month == 10 || month == 11) {
				 System.out.println("가을입니다.");
			 } else {
				 System.out.println("겨울입니다.");
			 }
		 }// if else
		
	}

}
