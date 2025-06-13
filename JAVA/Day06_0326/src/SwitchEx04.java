// if else if else 다중 조건문에 관한 실습
import java.util.Scanner;
public class SwitchEx04 {

	public static void main(String[] args) {
		int score = 0; // 점수
		char grade = ' '; // 학점

		Scanner scan = new Scanner(System.in);
		System.out.print("0부터 100사이 수학점수 입력 >> ");
		score = Integer.parseInt(scan.nextLine());
		
		if(!(score >= 0 && score <= 100)) { // 점수가 0이상이고 100이하가 아닌 경우 (!=>논리 부정)
			System.out.println("0부터 100사이 수학점수만 입력하세요!");
		} else {
			if(score >= 90 && score <= 100) {
				grade = 'A';
			} else if(score>=80) { // score >= 80 && score <= 89 이하 조건과 같다.
				grade = 'B';
			} else if(score>=70) {
				grade = 'C';
			} else if(score>=60) {
				grade = 'D';
			} else { // score >= 0 && score <= 59
				grade = 'F';
			} // if else if
			System.out.println("취득하신 수학 점수" + score + "는(은) "+grade + "학점입니다.");
		}
	}

}
