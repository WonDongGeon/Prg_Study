package 중첩클래스와중첩인터페이스;
/* 외부클래스 안에 선언된 내부 인터페이스 즉 중첩 인터페이스에 관한 실습소스)  
 */
public class Button {
	interface OnClickListener {
		void onClick(); //public abstract가 생략된 추상메서드
	} // 중첩 인터페이스 => Button$OnClickListener.class
	
	OnClickListener listener; //필드(속성) => 멤버변수 선언
	
	void setOnClickListener(OnClickListener listener) { // 매개변수 다형성 => 상속 + 업캐스팅
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick(); //업캐스팅 이후 오버라이딩 한 메서드를 호출
	}
}
