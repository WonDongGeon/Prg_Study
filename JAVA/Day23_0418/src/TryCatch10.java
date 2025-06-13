/* for반복문 안에서 try~catch문 예외 처리
 */
public class TryCatch10 {

	public static void main(String[] args) {
		int number =100;
		int result = 0;
		
		for(int i = 1; i <=10; i++) {
			try {
				result = number/ (int)(Math.random()*10) ; //random()정적메서드는 0.0이상 1.0미만 실수 숫자 난수 발생
				//=> *10하면 0.0이상 10.0미만 실수숫자 난수 => (int)로 형변환하면 소수점이하는 버리고 0이상 10미만 즉 0부터 9사이
				//정수 숫자 난수가 발생
				System.out.println("result = " +result);//정수 숫자를 나눗셈하면 몫만 구함.
			}catch(ArithmeticException e) {
				System.out.println("0"); //정수 숫자 난수가 0일때 예외가 발생해서 실행된다.
				
			}
		}
	}

}
