/* try~catch문에서 예외가 발생하든 발생하지 않든 무조건 마지막에 수행해야 하는 문장을 넣을 때는 finally에 기술한다.
 * 
 */
public class TryCatch05 {
	public static void main(String[] args) {
		int a = 10, b01 =0, b02 =2, result = 0;

		try {
			result = a/b02;
			System.out.println("result = " + result);
			
			result = a/b01; // 예외가 발생하고 아래문장 수행하지 않고 해당 catch{}블록문으로 이동
			System.out.println("result = " + result); // 이 문장 수행안하고 해당 예외 처리 catch 블록문으로 이동한다.
			
			result = a/b02;
			System.out.println("result = " + result); // 이 문장 수행안함.
			
		}catch(ArithmeticException ae) { //보다 구체적인 자손클래스를 먼저 기술
			ae.printStackTrace();
		}catch(Exception e) { //예외 처리 부모클래스는 나중에 기술
			System.out.println("에외 처리 : " + e);
		}finally {
			System.out.println("예외와 상관없이 무조건 마지막에 실행");
		}
	}
}
