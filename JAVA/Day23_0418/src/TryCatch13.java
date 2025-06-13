
public class TryCatch13 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(7/0); //예외 발생
			System.out.println(4); //실행 안함.
		}catch(ArithmeticException ae) {
			/* 문제) ae 매개변수가 ArithmeticException 타입으로 형변환이 가능한가? 라는 조건 추가코드를 하고
			 * 출력문장은 "true" 출력되게 해보자.
			 */
			if(ae instanceof ArithmeticException) {
				System.out.println(true);
			}
		}catch(Exception e) {
			System.out.println("Exception");
		}
	}
}
