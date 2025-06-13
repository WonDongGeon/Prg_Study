/* 메서드 참조에서 정적 메서드 참조와 인스턴스 메서드 참조 실습을 위한 클래스 설계) */
public class Calculator {

	//정적메서드
	public static int staticMethod(int x,int y) {
		return x+y;
	}
	
	//인스턴스 메서드
	public int instanceMethod(int x,int y) {
		return x + y;
	}
}
