/* 예외가 발생하지 않았을 때 try~catch 문 실행순서)
 * 
 */
public class TryCatch11 {
	public static void main(String[] args) {
		System.out.println(1);
		try {
			System.out.println(2);
			System.out.println(3);
		}catch(Exception e) {
			System.out.println(4); //예외가 발생하지 않으면 이 문장 수행 안함.
		}
		System.out.println(5);
	}
}
