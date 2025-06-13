// while 조건식을 true로 설정하면 영원히 반복하는 반복문인 무한루프문이 된다. 이 경우 스캐너로 부터 숫자로 입력받아서 누적합을 구하고
// 0을 입력한 경우 조건식을 거짓으로 해서 반복문을 종료시킨다.
import java.util.Scanner;
public class WhileEx01 {
	public static void main(String[] args) {
		int number = 0;
		int sum = 0;
		boolean flag = true; //while 조건식에 설정할 boolean 타입 변수
		
		System.out.println("누적합을 구할 숫자를 입력하세요!. 반복문을 끝내려면 0을 입력");
		
		while(flag) { // while 조건식이 true이면 영원히 반복하는 무한루프문이 된다.
			System.out.print(">>");
			
			Scanner scan  = new Scanner(System.in);
			String inputNumber  = scan.nextLine(); //스캐너를 사용해서 문자열로 읽어들임.
			number = Integer.parseInt(inputNumber);
			
			if(number != 0) {
				sum = sum + number; //복합대입연산자로 줄이면 sum += number, 입력한 숫자값의 누적합
			}else { //입력값이 0일때 실행
				flag  = false; // 반복문을 종료
			}
		} // while end
		System.out.println("누적 합계 = " + sum);
	}
}
