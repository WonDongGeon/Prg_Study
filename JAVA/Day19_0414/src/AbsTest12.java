/* 추상클래스 특징)
 * 1. 추상클래스도 일반 클래스와 마찬가지로 일반 속성과 메서드가 올 수 있다.
 * 2. 추상클래스에는 일반 클래스에서 올 수 없는 abstract 키워드로 정의되는 추상메서드가 올 수 있다.
 * 추상메서드는 {}가 없고, 실행문장이 없고, 호출이 불가능하다.
 * 
 */
class Abs12 {
	//abstract void pr(); // 추상메서드 정의 => 일반 클래스에서는 추상메서드가 올 수 없다.
}
abstract class Abs13 { // 추상클래스 Abs13정의
	int a = 10; //일반 속성도 올 수 있다.
	
	void print() {
		//일반 메서드도 올 수 있다.
	}
	abstract void pr02(); //추상클래스에는 추상메서드가 올 수 있다.
}
public class AbsTest12 {
	public static void main(String[] args) {
		
	}
}
