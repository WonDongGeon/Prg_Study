/* 업캐스팅 이후 오버라이딩 한 메서드를 호출
 */
class Mother06 {
	public void m06() {
		System.out.println("부모클래스 메서드 m06()");
	}
}
class Child06 extends Mother06 {
	
	@Override
	public void m06() {
		System.out.println("오버라이딩한 메서드 m06()");
	}
	public void ch06() {
		System.out.println("자손클래스 메서드 ch06()");
	}
}
public class RefCast06 {
	public static void main(String[] args) {
		Mother06 m = new Child06(); //업캐스팅 => 자동형변환
		m.m06();
	}
}
