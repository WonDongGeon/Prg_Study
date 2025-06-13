package 중첩클래스와중첩인터페이스;

public class ButtonExample {
	public static void main(String[] args) {
		Button btn01 = new Button();
		
		btn01.setOnClickListener(new CallListener()); //매개변수 다형성
		btn01.touch();
		
		btn01.setOnClickListener(new MessageListener());
		btn01.touch();
	}
}
