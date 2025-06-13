/* 메서드 오버라이딩과 오버로딩의 차이점 )
 * 	메서드 오버로딩 : 오버로딩은 상속과 관련이 없다. 동일한 같은 한 클래스내에서 같은 이름의 메서드를 여러번 중복해서 정의하는 것을 말한다.
 * 메서드 오버라이딩은 전체조건이 상속이 되어야 적용된다. 상속관계에서 부모의 메서드 이름, 전달인자 개수와 타입, 메서드 리턴타입
 * 동일한 원형을 자손에서 상속받은 상태에서 자손에 맞게 {} 내의 본문 실행문장을 변경 수정하는 것을 말한다.
 * 
 * 생성자는 메서드의 일종이다 보니 상속과 관련 없는 생성자 오버로딩 문법은 존재한다. 하지만 생성자는 상속되지 않기 때문에
 * 생성자 오버라이딩 문법은 존재하지 않는다.
 */
class Parent03 { // extends Object가 생략됨
	public void p03() {
		System.out.println("부모의 메서드 po3");
	}
	
}
class Child03 extends Parent03 {

	@Override
	public void p03() {
		super.p03(); // 부모클래스 메서드를 호출
		System.out.println("오버라이딩한 메서드");
	}
	public void ch03() {
		System.out.println("자손에서 정의한 메서드 ch03");
	}
}
public class ExtendTest03 {
	public static void main(String[] args) {
		Child03 child = new Child03();
		child.p03(); // 오버라이딩한 메서드 호출
		child.ch03(); 
		System.out.println("\n ===================== \n");
		
		Parent03 p = new Parent03();
		p.p03(); //부모의 메서드를 호출
	}
}