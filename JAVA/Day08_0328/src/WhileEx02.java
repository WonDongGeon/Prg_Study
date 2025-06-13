/* Math.random() 으로 1~100사이의 임의의 정수 숫자 난수를 발생시키고, 사용자로부터 1부터 100사이의 임의의 정수값을 입력받아서
 * 맞추는 예제. do~while 반복문을 사용한다.
 * 
 */
import java.util.Scanner;
public class WhileEx02 {
	public static void main(String[] args) {
			int inputNumber = 0;
			
			int answer = (int)(Math.random() * 100) + 1; //random()메서드는 0.0이상 1.0미만 사이의 실수 숫자 난수를 발생. =>
			//*100하면 0.0이상 100.0미만 사이의 실수 숫자 난수가 발생 => (int)로 캐스팅 하면 소수점 이하는 반올림하지 않고 버림. 
			// 0이상 100미만 => 1하면 1이상 101미만 즉 1부터 100사이의 임의의 정수 숫자 난수가 발생

			Scanner scan = new Scanner(System.in);
			
			do {
				System.out.print("1부터 100사이의 임의의 정수 숫자를 입력>>");
				inputNumber  = Integer.parseInt(scan.nextLine());
				
				if(inputNumber > answer) {
					System.out.println("더 작은 숫자를 입력하세요!");
				} else if(inputNumber < answer) {
					System.out.println("더 큰 숫자로 입력하세요!");
				}
			}while(inputNumber != answer);
			System.out.println("정답 숫자는 " + inputNumber + " 입니다.");
	}
}
