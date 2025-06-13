/* 부모 인터페이스의 default 메서드와 부모 클래스의 일반 메서드가 동일한 경우 자손에서는 부모 인터페이스의 디폴트 메서드는 무시되고,
 * 부모 클래스의 일반 메서드가 상속되어 진다.
 * 
 */
class ParentClass03 {
	public void display() {
		System.out.println("부모 클래스 일반 메서드");
	}
}
interface ParentInter03 {
	default void display() {
		System.out.println("부모 인터페이스의 디폴트 메서드");
	}
}
class Childclass03 extends ParentClass03 implements ParentInter03 {
	
}
public class InterEx03 {

	public static void main(String[] args) {
		Childclass03 ch = new Childclass03();
		ch.display(); //부모클래스의 일반메서드가 상속되어져서 호출되어진다.
	}

}
