/* 자바 GUI 중의 하나인 AWT로 프레임윈도우 창을 만든 다음 멀티스레드 왼쪽에서 오른쪽으로 노란글자가 항상 지나가는 것을
 * 만드는 스레드 응용 예제)
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame; // java.awt패키지의 AWT 프레임 윈도우 API클래스를 임포트
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GraphicFrame04 extends Frame implements Runnable {
	int x = 0; //프레임 윈도우 x좌표
	
	public GraphicFrame04() {
		this.setBackground(new Color(0,0,0)); //this.은 생략가능, AWT프레임 윈도우 배경색을 검정으로 처리
		setSize(370, 150); //프레임 윈도우 폭과 높이를 지정
		setVisible(true); //프레임 윈도우 항상 나오게 하기
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose(); //자원해제
				System.exit(0); //현재 프로그램(열려진 AWT 프레임 윈도우 창) 정상적인 종료
			} //현재 프레임 윈도우 닫기하면 호출
		}); //프레임 윈도우 이벤트 등록메서드 => 익명클래스 즉 내부 무명클래스로 컴파일된다.
		//(외부클래스명$번호.class => GraphicFrame04$1.class)
	} //생성자
	@Override
	public void run() { // 스레드 문장 구현
		while(true) {
			try {
				Thread.sleep(100); //스레드를 일정 시간 동안 잠시 쉬게한다(100 : 0.1초 간)
			}catch(InterruptedException e) {}
			repaint(); //자바의 GUI 프로그래밍(예 : AWT, Swing)에서 사용되는 메서드로, 컴포넌트를 다시 그리조가 호출한다.
			//repaint()메서드는 시스템에게 나중에 적정할 시점에 다시 그려달라고 요청하는 방식이다.
			x += 5; //x좌표 5씩 증가
		}//무한루프문
	}//run()
	@Override
	public void paint(Graphics g) {
		Dimension d; //Dimension은 폭과 높이를 가지는 클래스
		d = getSize(); //프레임 창의 크기를 구하여 Dimension객체로 반환
		g.setColor(Color.orange); //글자 색을 오랜지색으로 설정
		g.drawString("JAVA", x, d.height/2); //스레드에 의해서 x좌표는 항상 변경된다.
		
		if(x>d.width) //x좌표가 프레임 폭을 벗어나면
			x = 0; //다시 왼쪽 처음부터 반복
	} //무엇을 그리고자 이 메서드를 오버라이딩 한다.
	
}
public class ThreadEx04 {
	public static void main(String[] args) {
		GraphicFrame04 f = new GraphicFrame04();
		Thread th = new Thread(f);
		th.start(); //스레드 시작
	}
}
