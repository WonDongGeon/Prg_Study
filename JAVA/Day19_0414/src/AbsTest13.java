/* 추상클래스 특징)
 * 추상클래스의 추상메서드를 상속받은 자손클래스에서는 반드시 부모 추상클래스의 추상메서드를 오버라이딩을 해야 한다.
 * 그래야만 자손 클래스 객체 생성이 가능하다. 
 */
abstract class Abs14 { //부모 추상클래스 정의
	abstract void pr(); //추상 메서드 정의
}
class Child14 extends Abs14 {

	@Override
	void pr() {
		System.out.println("추상메서드를 오버라이딩을 한 일반메서드");
	}
}
public class AbsTest13 {
	public static void main(String[] args) {
		Abs14 abs; //추상클래스로 참조타입 abs변수 선언
		abs = new Child14(); //추상클래스로 업캐스팅이 가능함.
		abs.pr(); //업캐스팅 이후 오버라이딩한 메서드 호출
	}
}
