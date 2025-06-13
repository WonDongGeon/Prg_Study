/*18장.추상 클래스와 final.pdf No.21 2번 문제)
 * 메서드를 final로 선언하면 마지막 메서드가 되어서 자손에서 더 이상 오버라이딩을 허용하지 않는다.
 */
class A {
	public final int method01() { //final 메서드
		return 0;
	}
}
class B extends A {
	/*
	 * @Override 
	 * public int method01() { 
	 * 	return 1; 
	 * }
	 */
}
public class Ex18_02 {
	public static void main(String[] args) {
		B b=new B( ); 
		System.out.println("x = " + b.method01());
	}
}
