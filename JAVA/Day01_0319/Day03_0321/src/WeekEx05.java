/* 삼항 조건연산자
 *  조건식 ? 조건식이 참이면 실행 : 조건식이 거짓이면 실행
 */
import java.util.Scanner;
public class WeekEx05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* ctrl + shift + 영문자 o 단축키로 java.util 패키지를 임포트한다.
		 *  Scanner 내장 api 클래스는 무엇을 입력받기 위해서 사용한다.
		 *  System.in은 키보드 입력장치와 연결된다.
		 *  new 키워드로 새로운 객체명 scan을 생성
		 */
		
		System.out.print("첫번쨰 정수값 입력>>");
		String inputNumber01 = scan.nextLine();//문자열로 입력받음
		int a  = Integer.parseInt(inputNumber01); //parseInt() 내장 정적메소드로 입력받은 문자열 숫자를 정수 숫자로 변경
		
		System.out.print("두번째 정수값 입력>>");
		String inputNumber02 = scan.nextLine();
		int b = Integer.parseInt(inputNumber02);
		
		int max = (a>b) ? a : b; // 삼항 조건 연산자
		System.out.println(a + " 와 " + b + "중 더 큰수는 ? " + max);
	}

}
