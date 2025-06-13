/* 인터페이스에서 인터페이스 상속은 extends 키워드를 사용한다. 인터페이스 간 상속은 다중상속이 가능하다
 */
interface IHello11 {
	void hello(String name); //public abstract가 생략된 추상메서드
}
interface IGoodBye {
	public abstract void sayGoodBye(String name);
}
interface ITotal extends IHello11, IGoodBye { //두 부모 인터페이스로부터 다중 상속을 받고 있다.
	public abstract void greeting(String name);
}
class SubClass11 implements ITotal {
	@Override
	public void hello(String name) {
		System.out.println(name + "안녕~");
	}
	@Override
	public void sayGoodBye(String name) {
		System.out.println(name + "잘가~");
	}
	@Override
	public void greeting(String name) {
		System.out.println(name + "반가~");
	}
}
public class AbsEx11 {

	public static void main(String[] args) {
		SubClass11 sub = new SubClass11();
		sub.hello("홍길동");
		sub.sayGoodBye("이순신");
		sub.greeting("강감찬");
	}

}
