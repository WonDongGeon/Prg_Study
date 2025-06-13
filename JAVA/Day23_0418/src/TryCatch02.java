/* 정수 숫자를 0으로 나누면 자바는 ArithmeticException 예외를 발생시킨다.
 * 이 예외를 if else 문으로 처리한다.
 * 
 */
public class TryCatch02 {

	public static void main(String[] args) {
		int a = 10, b01 = 0, b02 = 2, c = 10;
		
		if(b02 == 0) {
			System.out.println("예외 상황이 발생했습니다.");
		} else {
			c = a/b02; //정수 숫자를 나눗셈하면 몫만 구함.
			System.out.println("c = " + c);
		}
		if(b01 == 0) {
			System.out.println("예와 상황이 발생했습니다.");
		} else {
			c = a/b01; 
			System.out.println("c = " + c);
		}
	}

}
