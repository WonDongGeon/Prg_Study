package 람다식;

public class UsingThisExample {

	public static void main(String[] args) {
/* 문제) UsingThis 외부클래스 객체명 usingThis를 생성한 다음, 인스턴스 멤버내부클래스 객체명 inner를 생성해서
 * 인스턴스 멤버내부클래스에 정의된 method()를 호출하는 과정코드를 해보자.
 * 
 */	
		UsingThis usingThis = new UsingThis();
		UsingThis.Inner inner = usingThis.new Inner();
		inner.method();
	}
}
