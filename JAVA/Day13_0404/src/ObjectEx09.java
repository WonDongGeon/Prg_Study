/* 메서드 오버로딩이란?
 *  동일한 같은 클래스내에서 동일 이름의 메서드를 여러 번 중복해서 정의하는 것을 말한다.
 * 
 * 오버로딩 된 메서드 구분요건)
 * 1. 전달인자(매개변수) 타입을 다르게 한다.
 * 2. 매개변수 개수를 다르게 한다.
 */
class Mt09 {
	int abs(int data) {
		if(data < 9) {
			data =-data;
		}
		return data;
	}
	double abs(double data) { //전달인자 타입을 다르게 한 메서드 오버로딩
		if(data < 0) {
			data = -data;
		}
		return data;
	}
	void p(int a) {
		System.out.println(a);
	}
	void p(int a, int b) { //매개변수 개수를 다르게 한 메서드 오버로딩
		System.out.println(a+"\t" + b);
	}
}
public class ObjectEx09 {
	public static void main(String[] args) {
		Mt09 mt = new Mt09();
		int result = mt.abs(-100);
		System.out.println("-100의 절대값 = " + result);
		System.out.println("-10.9의 절대값 = " + mt.abs(-10.9));
		mt.p(10); mt.p(10,20);
	}
}
