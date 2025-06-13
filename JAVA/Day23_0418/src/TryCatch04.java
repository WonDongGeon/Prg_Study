/* 하나의 try문과 복수개의 catch 블록문{} 이 오는 경우는 catch 블록문에 예외 처리 자손클래스를 먼저 기술하고, 
 * 예외처리 부모는 나중에 기술한다. 이유는 해당 catch블록문을 순차적으로 찾아서 가장 관련성 있는 예외처리를 먼저 하기 때문이다.
 * 
 */
public class TryCatch04 {
	public static void main(String[] args) {
		int a = 10, b01 =0, b02 =2, result = 0;
		
		try {
			result = a/b02;
			System.out.println("result = " + result);
			
			result = a/b01; //정수 숫자를 0으로 나눠서 예외가 발생함.
			System.out.println("result = " + result); // 이 문장 수행안하고 해당 예외 처리 catch 블록문으로 이동한다.
		}catch(ArithmeticException e) { //보다 구체적인 자손클래스를 먼저 기술
			System.out.println("예외 발생");
		}catch(Exception e) { //예외 처리 부모클래스는 나중에 기술
			e.printStackTrace(); // 예외 족적(발자취, 흔적)을 남김
		}
	}
}
