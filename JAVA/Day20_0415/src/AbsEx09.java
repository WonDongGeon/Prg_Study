/* 인터페이스는 하나 이상의 부모로부터 다중 상속을 할 수 있다.
 */
interface IHello09 {
	void sayHello(String name); //public abstract 생략
}
interface IGoodBye09 {
	public abstract void sayGoodBye(String name);
}
class SubClass09 implements IHello09, IGoodBye09 {
	@Override
	public void sayGoodBye(String name) {
		System.out.println(name + "씨 잘가세요.");
	}
	@Override
	public void sayHello(String name) {
		System.out.println(name + "씨 안녕하세요.");
	}
}
public class AbsEx09 {
	public static void main(String[] args) {
		SubClass09 sub =new SubClass09();
		sub.sayGoodBye("홍길동");
		sub.sayHello("이순신");
	}
}
