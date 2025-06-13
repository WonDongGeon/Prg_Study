/* Switch ~ case 다중 선택문(조건문)
 * 
 */

import java.util.Scanner;
public class SwitchEx01 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("영문나라 이름 입력(korea)>>");
		String nara_name = scan.nextLine();
		char first_ch = nara_name.charAt(0); // 첫 단일문자 구함
		
		switch(first_ch) {
		case 'k' : 
		case 'K' : System.out.println("대한민국"); break;
		case 'a' :
		case 'A': System.out.println("미국"); break;
		case 'c' :
		case 'C' : System.out.println("캐나다"); break;
		case 'j' : 
		case 'J' : System.out.println("일본"); break;
		default: System.out.println("해당하는 나라 이름이 없습니다."); break;
		
		}
		
	}
}
