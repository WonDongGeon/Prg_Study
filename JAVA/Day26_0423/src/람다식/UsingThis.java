package 람다식;

/* 중첩 클래스 중에서 인스턴스 멤버 내부클래스의 메서드내에서 람다식 익명 객체 구현 부분에서 외부클래스의 멤버변수나 내부클래스의 멤버변수 접근법에 관한 소스*/
public class UsingThis {
	private int outterField = 10;
	
	//인스턴스 멤버 내부클래스 정의
	class Inner {
		int innerField = 20;
		
		void method() {
			//람다식 익명객체를 구현
			MyFunInterface4 fi = () -> {
				System.out.println("outterField = " + outterField);
				System.out.println("UsingThis.this.outterField = " + UsingThis.this.outterField);
				
				System.out.println("intterField = " + innerField);
				System.out.println("this.innerField = " + this.innerField);
			};
			fi.method();
		}
	}
}
