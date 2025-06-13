/* java.util.function 패키지의 Supplier 계열의 내장함수형 인터페이스 특징)
 *  1.매개값은 없고 리턴값은 있다.
 */

import java.util.function.IntSupplier;

public class SupplierExample {
	public static void main(String[] args) {

		IntSupplier intSupplier = () -> {
			/* 문제) Math.random()메서드를 사용해서 1부터 6사이의 임의의 정수숫자 난수를 발생해 그 값을 리턴하여 임의의 주사위 눈의
			 * 수를 구하는 프로그램 코드를 만들어 보자.
			 */
			int num = (int)(Math.random()*6)+1;//random()메서드는 0.0이상 1.0미만 사이의 실수 숫자 난수를 발생=>*6하면
			//0.0이상 6.0미만 => (int)로 형변환 하면 소수점 이하는 버리고 0이상 6미만 => +1을 하면 1이상 7미만 즉 1부터 6사이의
			//임의의 정수숫자 난수가 발생
			return num;
		};
		
		int resultNumber = intSupplier.getAsInt();
		System.out.println(" 임의의 주사위 눈의 수 = "+ resultNumber);
	}
}
