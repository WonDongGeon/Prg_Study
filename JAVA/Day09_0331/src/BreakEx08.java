/*	while, for 무한루프문을 사용한 여름 음식 메뉴 선택 프로그램
 * 다중 반복문을 중단하기 위한 임의의 레이블문도 들어간다.
 */
import java.util.Scanner;
public class BreakEx08 {
	public static void main(String[] args) {
		int menuNumber = 0; //메뉴 번호
		int moneyPrice = 0; //계산할 값

		Scanner scan  = new Scanner(System.in);
		outer: // 다중 반복문을 중단하기 위한 임의의 레이블명 지정(레이블명 : outer
		while(true) {
			System.out.println("1 - 물냉면");
			System.out.println("2 - 비빔냉면");
			System.out.println("3 - 삼계탕");
			System.out.print("원하는 여름 음식 메뉴(1~3)를 선택하세요. (종료 : 0) >> ");
			
			menuNumber = Integer.parseInt(scan.nextLine());
			
			if(menuNumber == 0) {
				System.out.println("여름 음식 선택 메뉴판을 종료합니다.");
				break; // while 반복문 종료
			} else if(!(1 <= menuNumber && menuNumber <= 3)) {
				System.out.println("잘못된 메뉴번호를 선택했습니다.");
				continue; // 아래 문장 수행 안함
			} // if else if
			
			for(;;) {
				System.out.print("계산할 값 입력(계산 종료 : 0, 전체 종료 : 99) >> ");
				moneyPrice = Integer.parseInt(scan.nextLine()); // 문자열로 입력받아서 정수숫자로 변경
				
				if(moneyPrice == 0) {
					break; // for 무한루프, 계산 종료
				}
				if(moneyPrice == 99) {
					break outer; // 전체종료 => while, for 무한루프문을 벗어난다.
				}
				switch(menuNumber) {
				case 1: System.out.println("물냉면 값 = " + moneyPrice); break;
				case 2: System.out.println("비빔냉면 값 = " + moneyPrice);	break;
				case 3: System.out.println("삼계탕 값 = " + moneyPrice); break;
				} 
			} //for 무한루프문
		}//while 무한루프문
	}
}
