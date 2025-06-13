//16장 상속.pdf의 No.31 8번문제)
class A {
	public A() {
		System.out.println("hello from a");
	}
}
class B extends A {
	public B() {
		System.out.println("hello from b");
		//super(); //super()가 첫 줄이 아닌 출력문 다음으로 오기 때문 첫줄이여야하는 이유는 부모 클래스를 먼저 초기화해줘야하기 떄문에
		// 
	}
}
public class Ex16_09 {
	public static void main(String[] args) {
		A a =new B();
	}
}
