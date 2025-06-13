/* 부모 클래스와 인터페이스를 자손에서 동시에 상속받는 예
 * 
 */
interface IHello10 {
	public abstract void sayHello(String name);
}
abstract class GoodBye10 {
	public abstract void sayGoodBye(String name);
}
class SubClass10 extends GoodBye10 implements IHello10 {
	@Override
	public void sayHello(String name) {
		System.out.println(name + "씨 안녕하세요.");
	}

	@Override
	public void sayGoodBye(String name) {
		System.out.println(name + "씨 잘가세요.");
	}
}
public class AbsEx10 {
	public static void main(String[] args) {
		SubClass10 sub = new SubClass10();
		sub.sayHello("홍길동");
		sub.sayGoodBye("이순신");
	}
}
