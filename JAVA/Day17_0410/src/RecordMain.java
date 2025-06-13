import net.daum.dto.Rectangle;

public class RecordMain {
	static void area(Object obj) { //Object은 자바 최상위 부모클래스
		if(obj == null) {
			return; //종료 
		} else if (obj instanceof Rectangle(int width, int height)) {// java 21에서 추가된 레코드 패턴을 사용 
			//instanceof 형변환 유무 판단 연산자
			System.out.println("사각형 면적 : " + (width * height));
		}
	} // area
	static void area2(Object obj) { //switch case 문에서 사용하는 레코드 패턴
		switch (obj) {
			case Rectangle(int width, int height) -> System.out.println("사각형 너비 = " + (width * height));
			case null, default -> System.out.println("unknown"); 
		}
	} // area2
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(10, 5);
		area(null);
		area(rect);
		System.out.println();
		area2(rect);
		area2(null);
	}
}
