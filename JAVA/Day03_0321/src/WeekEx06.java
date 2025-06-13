/* 자바의 논리연산자 종류)
 *  1. 논리연산자 결과값도 true or false이다.
 *  2. 논리연산자 종류 )
 *   &&(논리곱) : 입력값 모두 true이면 결과값은 true(참)이다. 나머지는 false
 *   ||(논리합) : 2개의 조건 중 하나라도 참이면이 결과값은 true(참)이다. 둘 다 
 *   !(논리부정) : 입력값이 true이면 결과값은 false이고, 반대로 입력값이 false이면 결과값이 true이다.
 */

import java.util.Scanner;
public class WeekEx06 {
	public static void main(String[] args) {
		boolean re = false;
		re=(true && true);
		System.out.printf("%b && %b : %b%n", true,true, re);
		
		re=(false || false);
		System.out.printf("%b || %b : %b%n", false,false, re);
		
		re=!false;
		System.out.printf("!%b : %b\n", false, re);
		
		Scanner scan = new Scanner(System.in);
		String result = "";
		
		System.out.print("나이 입력>>");
		String inputAge = scan.nextLine(); // nextLine()메소드로 문자열로 읽어들임.
		int age = Integer.parseInt(inputAge); // parseInt()메소드로 정수숫자로 변경
		
		result = (age >= 20 && age <= 29)?"20대":"20대가 아니다"; // 삼상 조건 연산자
		System.out.println(age+"세는 "+result);
	}
}
