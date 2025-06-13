// switch ~ case 문을 사용해서 주민번호 뒷자리 첫번째 값이 1, 3일 경우 남자,  2, 4일 경우 여자

import java.util.Scanner;
public class SwitchEx08 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("생물 주민 번호 입력(011231-4080212)>>");
		String juminNo = scan.nextLine();
		char regNo = juminNo.charAt(7); // 입력받은 주민번호 8번쨰 단일문자(첫번째 뒷자리 주민번호)
		
		switch(regNo) {
			case '1':
			case '3': System.out.println("당신은 남자입니다."); break;
			case '2':
			case '4': System.out.println("당신은 여자입니다."); break;
			default: System.out.println("유효하지 않는 주민번호입니다."); break;
		}
	}
}
