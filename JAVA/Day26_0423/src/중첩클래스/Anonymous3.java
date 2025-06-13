package 중첩클래스;

/* 외부클래스 메서드  내에 익명 객체를 구현하고 익명객체 내부에서 외부 클래스 메서드 소속의 매개변수나 지역변수를 사용하고자 할 경우에는
 * final 속성을 가진다.
 * 자바 8버전부터는 final속성은 생략가능하다.
 * 
 */
public class Anonymous3 {
	private int field;
	
	public void method(int arg01, int arg02) {
		int var01 = 0;
		int var02 = 0;
		
		field = 10; // 클래스 멤버변수
		
		//arg01 = 10; <- final은 값이 변경되지 않기 떄문에 밑에서 사용은 불가능함
		//arg02 = 20;
		
		//var01 = 30;
		//var02 = 40;
		
		Calculatable calc = new Calculatable() {
			@Override
			public int sum() {
				int result = arg01 + arg02 + var01 + var02 + field; 
				// arg01, arg2, var01, var02은 사용하면 외부 클래스 메서드의 변수는 final 속성 가져 사용할 수 없음
				return result;
			}	
		}; //익명 객체 구현을 위한 익명클래스(Anonymous3$1.class)
		
		System.out.println("계산 결과값 = " + calc.sum());
	} //외부 클래스 메서드
} // 외부 클래스
