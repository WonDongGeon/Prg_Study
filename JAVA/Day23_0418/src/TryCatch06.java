/* 참조변수만 선언하고 null이 대입된 상태에서 해당 클래스 소속의 멤버변수 등을 사용하고자 할 때는 완전한 객체주소가 
 * 주입된 것이 아니어서 NullPointerException 예외 오류를 발생시킨다. 이 예외 오류 잡기가 가장 힘들다.
 */
class Member06 {
	String id = "aaaaa";
	String name = "홍길동";
	String addr = "서울시 중랑구";
}
public class TryCatch06 {
	public static void main(String[] args) {
		Member06 m = null;
		
		try {
			System.out.println("회원아이디 : " + m.id + ", 회원 이름 : " + m.name +  ", 회원 주소 : " + m.addr);
		}catch(Exception e) {
			System.out.println("예외 발생 : " + e);
			
			m = new Member06();
			System.out.println("회원아이디 : " + m.id + ", 회원 이름 : " + m.name +  ", 회원 주소 : " + m.addr);
		}
	}
}
