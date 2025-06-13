/* 예외가 발생했을 때 try~catch 문 실행순서)
 */
public class TryCatch12 {
	public static void main(String[] args) {
		System.out.println(1);
		try {
			System.out.println(2);
			System.out.println(10/0); //정수 숫자를 0으로 나누면 예외가 발생
			System.out.println(3);//이 문장 수행 안함.
		}catch(Exception e) {
			System.out.println(4); //예외가 발생하면 실행
		}
		System.out.println(5);
	}
}
