import net.daum.model01.ShapeClass;
import net.daum.model02.Circ;
import net.daum.model02.Rect;
import net.daum.model02.Tria;

public class AbsEx02 {
	public static void main(String[] args) {
		
		Circ c = new Circ();
		Rect r = new Rect();
		Tria t = new Tria();
		
		c.draw();
		r.draw();
		t.draw();
		
		System.out.println("\n===================================>\n");
		
		ShapeClass ref; // 부모 추상클래스 타입으로 참조변수 선언 => 객체주소가 저장 안됨.
		
		ref = new Circ(); //업캐스팅
		ref.draw(); // 업캐스팅 이후 오버라이딩한 메서드를 호출
		
		ref =new Rect();
		ref.draw();
		
		ref = new Tria();
		ref.draw();
		
		System.out.println("\n===================================>\n");
		
		ShapeClass[] arr = new ShapeClass[3]; //배열크기가 3인 arr객체배열 생성
		arr[0] = new Circ();
		arr[1] = new Rect(); //업캐스팅
		arr[2] = new Tria();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i].draw();
		}
	}
}
