/* if else if 다중 조건문(선택문)으로 학점 구하기
 */

import java.util.Scanner;

public class EqualsEx09 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("0~100사이 자바 점수만 입력 >> ");
		int score = Integer.parseInt(scan.nextLine());
		
		System.out.print(score + "는(은) ");
		char grade = ' ';
		if(score >= 0 && score <= 100) {
			if(score >= 90 && score <= 100) {
				grade = 'A';
			} else if(score >= 80 && score <= 89) {
				grade = 'B';
			} else if(score >= 70 && score <= 79) {
				grade = 'C';
			} else if(score >= 60 && score <= 69) { // && score <= 69 조건은 생략해도 됨.(위 조건문 score >= 70에 걸리기 때문에)
				grade = 'D';
			} else {
				grade = 'F';
			}
			System.out.println(score + "는(은) " + grade + "학점입니다.");
		} else {
			System.out.println("자바 점수는 0~100사이 점수만 입력하세요!");
		} // if else
		
	}

}
