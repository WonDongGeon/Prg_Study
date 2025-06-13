//중첩 if else if문을 사용해서 학점 구하기(A+, A ... etc)

import java.util.Scanner;

public class SwitchEx05 {

	public static void main(String[] args) {
		
		int score = 0; // 점수
		char grade = ' '; //학점
		char opt = ' ';
		
		Scanner scan = new Scanner(System.in);
		System.out.print("0부터 100사이 영어점수 입력 >>");
		score = Integer.parseInt(scan.nextLine());
		
		if(!(score >= 0 && score <= 100)) {
			System.out.println("0부터 100사이 영어점수만 입력하세요!");
		} else {
			if(score >= 90) {
				grade = 'A';
				if(score >= 96 && score <=100) {
					opt = '+';
				} else if(score >= 90 && score <= 95) {
					opt = ' ';
				}
			} else if (score >= 80 && score <= 89) {
				grade = 'B';
				if(score >= 86) {
					opt = '+';
				} else { //score >= 80 && score <= 85
					opt = ' ';
				}
			} else if(score >= 70) {
				grade = 'C';
				if(score >= 76) {
					opt = '+';
				} else {
					opt = ' ';
				}
			} else if(score >= 60) {
				grade = 'D';
				if(score >= 66) {
					opt = '+';
				} else {
					opt = ' ';
				}
			} else { 
				grade = 'F';
			}
			System.out.printf("당신이 취득한 영어점수 %d는 %c%c학점입니다\n", score, grade, opt );
		} // if else
				
	}
		
}
