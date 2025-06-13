/* try ~catch으로 예외 처리
 * 
 * 
 * try {
 *  정상구문이 수행되다가 예외가 발생하면 아래문장을 수행하지 않고 예외 처리 catch블록문으로 이동해서 예외를 처리한다.
 *  }catch(예외처리 클래스 매개변수){
 *   예외 처리;
 *  }
 */
public class TryCatch03 {
	public static void main(String[] args) {
		// 정수 숫자를 0으로 나누어서 예외를 인위적 발생시킴
		int a = 10, b01 =0, b02 =2, c= 10;
		System.out.println("try 구문 실행전 : c = " + c);
		
		try {
			c = a/b02;
			System.out.println("(1)c = " + c);
			
			c = a/b01; //예외가 발생하고 아래문장 수행안함. 해당 catch블록으로 이동해서 예외처리
			System.out.println("(2)c = " + c);
			
			c= a/b02;
			System.out.println("(3)c = " + c); // 이 문장 수행안함
		}catch(Exception e) { // Exception은 예외처리 부모클래스
			System.out.println("예외 발생 : "  +e); //java.lnag.ArithmeticExceptio: / by zero이 예외 에러가 정수 숫자를
			//0으로 나누었을 때 발생하는 예외 에러이다.
		}
		System.out.println("try구문 수행후 c = " + c);
	}
}
