/* 생성자의 특징)
 * 1. 생성자는 메서드의 일종이다.
 * 2. 생성자도 오버로딩이 가능하다.
 * 
 */
class Member02 {
	private String mem_id; //회원이다
	private String mem_name; //회원이름
	private String mem_addr; //회원 주소 => 3개의 클래스 소속 멤버변수(속성) 정의
	
	public Member02() { // 전달인지가 없는 생성자를 기본생성자라고 한다. 기본 생성자는 default(디폴트) 생성자이다.
		//생성자가 오버로딩이 안되어 있을 때는 자바 컴파일러가 기본 생성자를 묵시적 제공한다.
		mem_id = "kkkkk"; mem_name = "홍길동"; mem_addr = "서울시 중랑구"; //생성자의 주된 기능인 인스턴스 멤버변수 초기화
	} 
	public Member02(String new_id, String new_name, String new_addr) {
		mem_id = new_id; mem_name = new_name; mem_addr = new_addr;
	} // 전달인자 개수가 다른 생성자 오버로딩
	public void print() {
		System.out.println("회원 아이디 : " + mem_id + ", 회원 이름 : " + mem_name + ", 회원 주소 : " + mem_addr);
	} // 사용자 정의 메서드 정의 => 초기화 된 멤버변수 값을 출력하는 기능을 가진다.
}
public class ConsEx02 {

	public static void main(String[] args) {
		Member02 member = new Member02(); //new Member02(); 에 의해서 전달인자가 겂는 기본 생성자를 호출
	    member.print();
	    
	    Member02 member2 = new Member02("aaaaa", "이순신", "서울시 동대문구"); //전달인자 3개짜리 오버로딩 된 생성자를 호출
	    member2.print(); //member와 member2는 서로 다른 객체주소를 가진다.
	}

}
