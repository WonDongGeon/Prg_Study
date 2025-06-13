package 중첩클래스와중첩인터페이스;

/* 클래스 소속의 변수 선언 위치에 따라 중첩 내부 클래스가 결정된다.
 * 멤버변수 선언위치 : 인스턴스 변수 선언위치이면 인스턴스 멤버 내부클래스가 되고, 정적변수 선언위치이면 정적멤버 내부 클래스가 된다.
 * 메서드 내에 선언된 변수를 지역변수라고 하는데 이 지역변수 선언 위치에 선언된 내부클래스를 코러 클래스라고 한다.
 */
class A { //외부클래스 => 바깥 클래스

	A() {
		System.out.println("A객체가 생성됨.");
	}
	
	//인스턴스 멤버 내부클래스(자바 21 버전에서는 인스턴스 필드(변수)와 정적변수(필드), 인스턴스 메서드, 정적메서드 모두 올수 있다.
	//하지만 자바 구버전(자바 20버전 이하)에서는 정적변수와 정적메서드는 올 수 없고, 인스턴스 변수와 인스턴스 메서드만 올 수 있다.
	//(단, static final 정적 상수는 예외적으로 허용)
	public class B {
		B() {
			System.out.println("B 객체가 생성됨");
		}
		int field01; //인스턴스 변수 올 수 있다.
		static int field02; //정적변수 올 수 있다.
		void method01() {} //인스턴스 메소드 올 수 있다.
		static void method02() {} //정적메서드도 올 수 있다.
	}//외부 클래스 $ 내부클래스명.class(A$B.class)
	
	//정적멤버 내부클래스(자바 21뿐만 아니라 그 이전버전에서도 인스턴스 변수, 정적변수, 인스턴스 메서드, 정적메서드가 올 수 있다.)
	static class C {
		C() {
			System.out.println("C 객체가 생성됨");
		}
		int field01;
		static int field02;
		void method01() {}
		static void method02() {}
	}//A&C.class
	
	void method() {
		//로컬 클래스 => 외부클래스명$1로컬클래스명.class(A$1D.class)
		class D {
			D() {
				System.out.println("D 객체가 생성됨");
			}
			/* 자바 21부터는 로컬클래스에도 인스턴스 변수, 정적변수, 인스턴스 메서드, 정적 메서드가 올 수 있다.
			 * 하지만 구버전(자바 20이하)에서는 인스턴스 변수와 인스턴스 메서드만 올 수 있고, 정적변수와 정적메서드는 올 수 없다.
			 * (단 static final 정적상수는 예외적으로 올 수 있다.)
			 */
			int field01;
			static int field02;
			void method01() {}
			static void method02() {}
		}
		D d = new D();
		d.field01 = 3;
		d.field02 = 10;
		d.method01();
		d.method02();
	}//method
}
