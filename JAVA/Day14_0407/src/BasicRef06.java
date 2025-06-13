/* 참조변수만 선언만 하고 객체주소를 대입 안하면 초기화 되지 않아서 해당 클래스 속성등에 접근못한다. 컴파일 에러가 난다.
 * 
 */
class Member06 {
	String id = "kkkkk";
	String name = "홍길동";
	String phone = "010-9999-9999";
}
public class BasicRef06 {
	public static void main(String[] args) {
		Member06 m; //참조변수 선언만 하고 객체주소 대입안된 상태
		m = new Member06(); // 컴파일 에러 때문에 써줌
		System.out.println("아이디 : " + m.id + ", 회원이름 : " + m.name + ", 회원주소 : " + m.phone);
	}
}
