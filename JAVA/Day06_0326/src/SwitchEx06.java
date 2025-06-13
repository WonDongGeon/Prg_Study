/* switch~case 다중 선택문(조건문)을 사용한 봄, 여름, 가을, 겨울, 계절 구하기)
 * 
 */

import java.util.Scanner;

public class SwitchEx06 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("1월 부터 12월 사이 월 입력하세요>>");
		int month = Integer.parseInt(scan.nextLine());
		
		if(month >= 1 && month <= 12) {
			switch(month){
				case 3: case 4: case 5: System.out.println("개나리가 만발한 봄입니다. 응봉산 개나리 축제 유명합니다.");
				break;
				case 6: case 7: case 8: System.out.println("더운 여름 입니다.");
				break;
				case 9: case 10: case 11: System.out.println("가을은 천고마비");
				break;
				case 12: case 1: case 2: System.out.println("겨울은 거리의 군고구마 먹고 싶은 계절입니다.");
				// default: System.out.println("겨울은 거리의 군고구마 먹고 싶은 계절입니다.")
			}
		} else {
			System.out.println("1월 부터 12월 사이 월만 입력하세요!");
		}
	}

}
