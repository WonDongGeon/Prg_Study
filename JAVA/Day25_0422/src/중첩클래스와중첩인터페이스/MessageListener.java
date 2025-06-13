package 중첩클래스와중첩인터페이스;

import 중첩클래스와중첩인터페이스.Button.OnClickListener;

//부모 중첩인터페이스 OnClickListener를 구현 상속한 자손클래스 MessageListener

public class MessageListener implements OnClickListener {

	@Override
	public void onClick() {
		System.out.println("메시지를 보냅니다.");
	}
}
