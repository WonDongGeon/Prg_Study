/* 부모와 동일한 멤버변수가 자손에서 정의된 경우와 자손에서 메서드가 오버라이딩 된 경우 호출되는 변수와 메서드에 관한 실습
 * 동일한 멤버변수가 있을 경우 부모로부터 상속받은 멤버변수 접근은 super.변수명으로 하고 자손에서 정의된 동일멤버변수명에 접근할 때는
 * this.변수명 또는 this.은 생략하고 변수명으로 접근한다. 멤버변수명을 다른말로 하면 속성 또는 필드라고 한다.
 * 
 */
class Mother10 {
	int a = 100;
	void m() {
		System.out.println("부모클래스 메서드");
	}
}
class Child10 extends Mother10 {
	int a =200;

	@Override
	void m() {
		System.out.println("오버라이딩한 메서드");
		System.out.println("a = " + a); // 200
		System.out.println("this.a = " + this.a); //this.은 생략가능함, 200
		System.out.println("super.a = " + super.a); // 100
	}
}
public class RefCast10 {
	public static void main(String[] args) {
		Mother10 m = new Child10(); //업캐스팅
		System.out.println("m.a = " + m.a); // 100
		m.m(); //업캐스팅 이후 오버라이딩한 메서드 호출
	}
}
