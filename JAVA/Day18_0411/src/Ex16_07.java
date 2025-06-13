//16장 상속.pdf의 No.29 6번문제)
class Base {
	Base(){
		System.out.println("Base");
	}
}
class Alpha extends Base {
	// 기본 생성자 묵시적 제공
}
public class Ex16_07 {
	public static void main(String[] args) {
		new Alpha();
		new Base();
	}
}
