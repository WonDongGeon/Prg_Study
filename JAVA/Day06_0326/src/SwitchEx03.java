//if ~ else 조건문 실습

import java.util.Scanner;
//import 키워드는 외부 패키지의 api 를 읽어들임.

public class SwitchEx03 {
	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		System.out.print("정수 숫자 입력>>");
		String temp = scan.nextLine();//문자열로 입력받음
		int a = Integer.parseInt(temp);//정수 숫자로 변경
		
		if(a == 0) {
			System.out.println("입력하신 숫자 "+a+"는(은) 0입니다.");
		}else {
			System.out.println("입력하신 숫자 "+a+"는(은) 0이 아닙니다!");
		}
	}
}
