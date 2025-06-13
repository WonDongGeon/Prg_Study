/* 사용자 정의 예외 클래스 생성
 */
class UserException extends Exception {
	public UserException(String msg) { 
		super(msg); //부모 클래스 생성자 호출
	}
}
public class TryCatch09 {

	public static void main(String[] args) {
		try {
			int a= -11;
			if(a<=0) {
				throw new UserException("양수가 아닙니다."); // 인위적 예외 발생
			}
		}catch(UserException e) {
				System.out.println(e.getMessage()); //예외 처리 메시지 출력
		}
	}
}
