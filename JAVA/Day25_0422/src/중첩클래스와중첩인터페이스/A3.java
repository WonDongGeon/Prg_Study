package 중첩클래스와중첩인터페이스;
/* 1. 인스턴스 멤버 내부클래스내에 선언된 메서드에서 외부클래스 A3에 선언된 인스턴스 변수, 인스턴스 메서드, 정적변수, 정적 메서드에
 * 접근이 가능하다.
 * 2. 정적 멤버 내부 클래스에 내에 선언된 메서드에서 외부클래스에 선언된 인스턴스 변수, 인스턴스 메서드는 접근이 안되지만
 * 정적변수, 정적메서드에는 접근이 가능하다.
 * 
 */
public class A3 {
		int field01; //인스턴스 변수
		void method01() {} //인스턴스 메서드
		
		static int field02; //정적 변수
		static void method02() {} //정적메서드
		
		//인스턴스 멤버 내부클래스 B
		class B {
			void method() {
				field01= 10;
				method01();
				
				field02 = 100;
				method02();
			}
		}//A3$B.class
		
		//정적멤버 내부클래스 C
		static class C {
			void method() {
				//field01 = 100;
				//method01();
				
				field02 = 100;
				method02();
			}
		}//A3$C.class
}
