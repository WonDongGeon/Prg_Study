/* 정적메서드 내에서는 this를 사용할 수 없다.
 * 정적메서드 내에서는 인스턴스 변수 사용 못함.
 * 
 */
class St05 {
	static int a =10; //정적변수
	int b = 20; //인스턴스 변수
	
	static void printA() { //정적메서드
		System.out.println(a);
		//System.out.println(this.b); //정적메서드 내에서 this는 사용못함. 이유는 this는 클래스 차원이 아닌 개체입장에서 다룬다.
	}
	void printB() { //인스턴스 메서드
		System.out.println(a); //정적변수 사용가능하다.
		System.out.println(this.a); //this 사용가능하다.
	}
	static void print() { //정적메서드
		//System.out.println(b); //정적메서드 내에서 인스턴스 변수 사용 못함.
	}
}
public class StaticEx05 {
	public static void main(String[] args) {
		
	}
}
