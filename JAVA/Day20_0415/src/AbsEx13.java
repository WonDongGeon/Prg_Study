/* 클래스와 클래스 간 직접연결하는 방식 => 스프링 부트 자바 프로젝트에서 권하고 싶지 않는 방식
 */
class A13 { // extends Object 생략
	public void method(B13 b) {
		b.methodB();
	}
}
class B13 {
	public void methodB() {
		System.out.println("methodB()");
	}
}
public class AbsEx13 {
	public static void main(String[] args) {
		A13 a = new A13();
		a.method(new B13());
	}
}