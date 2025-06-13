/* 자바 인터페이스.pdf 24쪽 1번문제)
 * 1. net.daum.model101 패키지에 부모 인터페이스 IShapeClass.java를 정의하고 추상메서드 void draw();를 정의한다.
 * 2. net.daum.model102 패키지에 부모 인터페이스를 상속받는 자손 클래스 Circ.java, Rect.java, Tria.java를 만들고
 * 추상메서드 draw()를 오버라이딩을 한 다음 실행문장으로 "타원을 그린다.", "사각형을 그린다.", "삼각형을 그린다"로 한다.
 * 그런 다음 다음과 같은 출력 결과물이 나오게 만든다.
 * 
 * 출력결과물)
 * 타원을 그린다
 * 사각형을 그린다.
 * 삼각형을 그린다.
 * 
 */
import net.daum.model101.IShapeClass;
import net.daum.model102.Circ;
import net.daum.model102.Rect;
import net.daum.model102.Tria;
public class Ex19_09 {
	public static void main(String[] args) {
		IShapeClass ref;
		ref =new Circ();
		ref.draw();
		
		ref= new Rect();
		ref.draw();
		
		ref= new Tria();
		ref.draw();
	}
}
