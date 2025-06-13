/* 인터페이스에 오는 모든 변수는 public static final로 인식되는 정적상수만 올 수 있다.
 */
interface IColor12 {
	int RED = 1; //public static final이 생략된 정적상수 RED
	public static final int GREEN = 2;
	public static final int BLUE = 3;
	
	void setColor(int c); //public abstract 생략
	public abstract int getColor(); //추상메서드
}
abstract class Abstract implements IColor12 { //
	int color = GREEN; // 추상클레스에는 일반 변수가 올 수 있다. 일반 변수는 color를 가리킴
	@Override
	public void setColor(int c) { // 구현된 메서드도 가질 수 있다.(오버라이딩)
		color = c;
	}
}
class SubClass12 extends Abstract {
	@Override
	public int getColor() { // 추상 메서드 오버라이딩
		return color;
	}
}
public class AbsEx12 {

	public static void main(String[] args) {
		SubClass12 sub = new SubClass12();
		sub.setColor(IColor12.RED);
		System.out.println(sub.getColor());
	}

}
