package 중첩클래스와중첩인터페이스;
/* 인스턴스 멤버 내부클래스와 정적 멤버 내부클래스 객체 생성과정 */
public class Main {
		public static void main(String[] args) {
			A a = new A(); //외부클래스 객체 a생성
			
			A.B b = a.new B(); //인스턴스 멤버 내부클래스 객체 생성과정
			b.field01 = 3;
			b.field02 = 30;
			b.method01();
			b.method02();
			
			A.C c = new A.C(); //정적멤버 내부클래스 객체생성 과정
			c.field01 = 3;
			c.field02 = 30;
			c.method01(); 
			c.method02();
			
			//로컬 클래스 객체 생성을 위한 메서드 호출
			a.method();
		}
}
