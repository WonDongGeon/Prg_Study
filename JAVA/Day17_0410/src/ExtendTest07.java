/* 상속에서 생성자 호출문제 에러를 막는 가장 합리적인 방법은 부모의 생성자가 오버로딩이 되었을 때 
 * 기본 생성자 묵시적 제공을 하지 않은 상태에서 명시적으로 부모의 기본 생성자를 코드를 하는 것 보다는
 * 자손에서 부모의 오버로딩 된 생성자를 호출하도록 경로를 변경하는 것이 가장 좋다.
 */
class Parent07 { //extends Object가 생략됨
	protected int x = 10;
	protected int y = 20;
	
	public Parent07 (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class Child07 extends Parent07 {
	protected int z = 30;
	
	public Child07() {
		super(100, 200); //부모의 오버로딩 된 생성자를 인위적 호출
	}
	public Child07(int x, int y, int z) {
		super(x,y);
		this.z =z;
	}
	public void print() {
		System.out.println("x = " + x + ", y = " + y + ", z = " + z); //x,y,는 상속받아서 호출
	}
}
public class ExtendTest07 {
	public static void main(String[] args) {
		Child07 ch07 = new Child07();
		ch07.print(); //100, 200 ,300
		
		Child07 ch08 = new Child07(1000, 2000, 3000);
		ch08.print();
	}
}
