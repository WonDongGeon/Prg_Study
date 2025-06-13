/* while 무한루프문을 사용한 메뉴 선택 예쩨)
 * 
 */

import java.util.Scanner;

public class BreakEx07 {

	public static void main(String[] args) {
		int menu = 0; // 선택한 메뉴번호
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1- 치킨");
			System.out.println("2- 오뎅탕");
			System.out.println("3- 장충동 왕족발 보쌈");
			System.out.print("원하는 야식메뉴(1~3)를 선택하세요. (종료 : 0) >> ");
			
			String temp = scan.nextLine(); // 문자열로 입력받는다.
			menu = Integer.parseInt(temp);
			
			if(menu == 0) {
				System.out.println("야식 메뉴 선택 프로그램을 종료합니다.");
				break;
			} else if(!(menu >= 1 && menu <=3)) {
				System.out.println("메뉴 번호를 잘못 선택했습니다. (종료 : 0)");
				continue;
			}
			System.out.println("선택한 메뉴 번호는 " + menu + " 번입니다.");
		}//while 무한루프문
		
	}

}
