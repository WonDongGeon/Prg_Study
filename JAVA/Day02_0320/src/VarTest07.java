/* 자바에서 무엇을 입력받기 위해서 java.util 패키지의 Scanner 내장 api클래스를 활용한다.
 * 외부 패키지의 api를 import, 즉 읽어오기 위한 STS(이클립스) 기준 단축키는 ctrl+shift+영문자 O
 */
import java.util.Scanner;
public class VarTest07 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		/* 1. System.in은 키보드 입력장치와 연결됨
		 *  2. new 키워는 새로운 객체명 scan을 생성하게 됨.
		 */
		
		System.out.print("나이 입력 : ");
		int age = Integer.parseInt(scan.nextLine()); // nextLine()메소드로 문자열을 읽어들이고 parseInt()정적메소드로 정수
		// 숫자로 변경한다.
		
		System.out.printf("나이 = %d %n", age);
		
	}

}
