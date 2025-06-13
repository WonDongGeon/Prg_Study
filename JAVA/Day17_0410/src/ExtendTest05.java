/* 생성자는 상속되지 않는다.
 * 상속관계에서 생성자 호출에 관한 소스
 */
class Parent05 extends Object { // extends Object은 생략가능
	protected int x = 10;
	protected int y = 20;
	
	public Parent05() {
		super(); //부모클래스 Object의 기본 생성자를 먼저 호출. 생략가능
		System.out.println("부모 Parent05 기본 생성자");
	}
}
class Child05  extends Parent05 {
	protected int z = 30;
	
	public Child05() {
		// super();가 생략됨, 부모의 Parent05(){}기본생성자를 먼저 호출
		System.out.println("자손 Child05 기본 생성자");
	}
	public void print() {
		System.out.println("x = " + x + ", y = " + y + ", z = " + z);
	}
}
public class ExtendTest05 {
	public static void main(String[] args) {
		Child05 ch05 = new Child05(); //new Child05();에 의해서 자손의 기본 생성자를 호출
		ch05.print();
	}
}
