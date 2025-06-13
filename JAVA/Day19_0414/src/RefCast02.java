/* 다운 캐스팅이란?
 * 1. 다운캐스팅을 할려면 사전에 상속관계를 만들어야 한다.
 * 2. 다운캐스팅은 부모클래스 타입을 자손타입으로 내리는 것을 말한다.
 * 3. 다운캐스팅을 하기전 반드시 사전에 업캐스팅을 해야 한다.
 * 4. 다운캐스팅을 할려면 자동형변환이 안되기 때문에 명시적인 형변환(캐스팅) 연산자를 사용해서 다운캐스팅을 해야 한다.
 */
class Mother02 { //extend Object 생략
	public void  m02() {
		System.out.println("부모클래스로 선언된 메서드 m02()");
	}
}
class Child02 extends Mother02 {
	public void ch02() {
		System.out.println("자손클래스로 선언된 메서드 ch02()");
	}
}
public class RefCast02 {
	public static void main(String[] args) {
		Mother02 m02 = new Child02(); //업캐스팅
		Child02 ch02;
		ch02 = (Child02)m02; //명시적인 형변환 연산자 : 다운캐스팅 (하지 않으면 컴파일 에러가 발생함)
		ch02.m02();  // 자손 클래스로 다운 캐스팅 되었기 떄문에 메서드 둘 다 호출 가능
		ch02.ch02(); 
	}
}
