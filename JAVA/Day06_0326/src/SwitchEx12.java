/* 자바 21에서 새롭게 추가된 패턴 매칭)
 * 자바 21부터는 switch 레이블에 패턴을 작성해서 표현값과 매칭을 시킬 수 있다. 이 방식은 표현값이 객체를 참조하는 변수 즉 레퍼런스 참조
 * 변수일 경우에만 사용할 수 있다. 표현값이 참조 타입 변수일 경우 패턴을 사용해서 타입 검사(업캐스팅, 다운캐스팅)를 수행하고, 자동 타입 변환을 해서
 * 레이블의 패턴 변수를 초기화한다. 그런 다음 초기화 된 변수를 중괄호 {} 블록에서 사용한다.
 * 
 * 표현값과 레이블 패턴 중 하나와 반드시 매칭이 되어야한다. 만약 매칭할 패턴이 없는 경우에는 나머지 매칭을 위해 default 문을 포함해야 한다.
 * 즉 표현값과 반드시 일치하는 레이블 실행문이 있어야 된다.
 */
import java.util.Date;
public class SwitchEx12 {
	public static void method01(Object obj) { // 매개변수 다형성, 상속, 업캐스팅, 오토박싱(자바 5버전에서 추가)
		/* public 접근권한 제어자는 내 자신 클래스 뿐만 아니라 같은 패키지 폴더의 다른 클래스, 외부 패키지의 상속받은 자손클래스와
		 *  다른 클래스 누구나 다 접근 가능하게 한다.
		 * 
		 */
		switch(obj) { //표현값이 object타입인 참조타입이다 보내 레이블 패턴을 사용할 수 있다.
			case Integer i -> System.out.println(i); // 다운캐스팅
			case String s -> System.out.println("\""+ s + "\""); // s패턴 변수 초기화, 오토박싱 문법 적용 안됨.
			case null, default -> System.out.println("null or 해당 사항 없다.");
		}	
	} // method01
	private static void method02(Object ob) { 
		/* 1. private 접근권한 제어자는 내 자신 클래스내에서만 접근 가능하다.
		 *  2. static 예약어는 해당 클래스로 직접 접근하는 정책메소드를 정의할 때 사용한다.
		 *  3. void는 반환 값이 없는 자료형이다. 즉 리턴 타입이 없다. Object은 자바 최상위 부모클래스이다.
		 * 
		 */
		String result = switch(ob) {
			case Integer i -> String.valueOf(i); // 정수 인자값을 문자열로 변환해서 반환
			case String s -> "\"" + s + "\"";
			case null, default -> "unknown";
		};
		System.out.println(result);
	}
	public static void main(String[] args) {
		method01(100);
		method01("100");
		method01(null);
		method01(new Date());
		
		System.out.println("\n =======================> \n");
		
		method02(10); // 오토박싱, 업캐스팅
		method02("10"); // 업캐스팅 
		method02(new Date());
	}
}
