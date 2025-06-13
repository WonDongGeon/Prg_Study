/* 인터페이스 특징)
 * 1. 인터페이스는 interface 키워드로 정의하고 자손클래스에서 implements키워드로 구현 상속받는다.
 * 2. 부모 인터페이스는 자손 클래스에서 하나 이상 부모 인터페이스로부터 다중 상속을 받을 수 있다.
 * 3. 인터페이스 오는 추상메서드는 public abstract 키워드로 정의한다. 이 키워드는 생략가능 하다.
 * 4. 부모 인터페이스를 구현 상속받은 자손클래스에서 부모의 모든 추상메서드를 반드시 오버라이딩을 해야 한다.
 * 그래야만 자손 클래스 객체 생성이 가능하다.
 */
interface IHello07 { //최초 작성한 인터페이스 부모는 없다.
	void sayHello(String name); //public abstract가 생략된 추상메서드, 추상메서드는 {}가 없고, 실행문장이 없고 호출이 불가능
}
class Hello07 implements IHello07 {

	@Override
	public void sayHello(String name) {
		System.out.println(name + "씨 안녕~");
	} // 자손에서 부모 인터페이스의 모든 추상메서드를 오버라이딩을 해야 한다.
}
public class AbsEx07 {
	public static void main(String[] args) {
		Hello07 h = new Hello07();
		h.sayHello("홍길동");
		IHello07 ih; //부모 인터페이스 타입으로 참조변수 선언 가능
		ih = new Hello07(); //부모 인터페이스 타입으로 업캐스팅이 가능
		ih.sayHello("이순신"); //업캐스팅 이후 오버라이딩 된 메서드 호출
	}
}
