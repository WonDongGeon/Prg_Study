/* 레퍼런스 간의 형변환 중 업캐스팅 특징)
 * 1. 업캐스팅을 할려면 사전에 상속관계를 만들어야 한다.
 * 2. 업캐스팅이란 자손타입이 부모타입으로 올라가는 현상을 말한다. 업캐스팅 암묵적인 자동형 변환을 해준다.
 * 
 */
class Mother01 { //extend Object 생략
	public void  m01() {
		System.out.println("부모클래스 메서드 m01()");
	}
}
class Child01 extends Mother01 {
	public void ch01() {
		System.out.println("자손클래스 메서드 ch01()");
	}
}
public class RefCast01 {
	public static void main(String[] args) {
		
		Child01 ch01 = new Child01();
		ch01.m01(); //상속받아서 호출
		ch01.ch01(); //자손에서 정의한 메서드 호출
		
		Mother01 m01; // 부모클래스 참조변수 선언 => 객체주소가 저장안된 참조변수
		m01 = ch01; //업 캐스팅 (자식 클래스의 객체 주소 저장)
		m01.m01(); // 자식에서 부모로 업이 되었기 때문에 자식 클래스에 있는 메서드 ch01은 호출할 수 없음.
		
		System.out.println("\n====================>\n");
		
		Mother01 m02 = new Child01(); //업캐스팅
		m02.m01();
		
	}
}
