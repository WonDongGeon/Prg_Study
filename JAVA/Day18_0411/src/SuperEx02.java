/* this() : 상속과 관련이 없다. 같은 클래스 내에서 오버로딩 된 다른 생성자를 호출할 떄 사용한다.
 * super() : 자손에서 부모클래스의 생성자를 호출할 때 사용한다.
 */
class Father02 { // extends Object이 생략됨
	int x = 1;
	int y = 2;
	
	Father02(int x, int y) {
		this.x = x;
		this.y = y;
	} //생성자 오버로딩을 하면 기본 생성자 묵시적 제공을 안한다.
}
class Son02 extends Father02 {
	int z = 3;
	
	Son02() {
		this(10,20,30); //같은 클래스내의 오버로딩 된 다른 생성자를 호출
	}
	Son02(int x, int y, int z) {
		super(x,y); //부모의 오버로딩 된 생성자를 호출
		this.z =z;
	}
	void print() {
		System.out.println("x= " + x + ", y = " + y + ", z = " + z);
	}
}
public class SuperEx02 {
	public static void main(String[] args) {
		Son02 s02 = new Son02();
		s02.print();
	}
}
