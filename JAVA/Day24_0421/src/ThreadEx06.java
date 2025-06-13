/* 스윙 GUI를 사용한 멀티스레드 예)
 * 카운터 다운과 스윙 GUI 입력폼 실행이 스레드에 의해서 동시 작업
 */
import javax.swing.JOptionPane;
class Thread06 extends Thread {
	@Override
	public void run() {
		for(int  i = 10; i >= 1; i--) {
			System.out.println(i);
			try {
				sleep(1000); //1초간 일시정지, 1초간격으로 카운터 다운이 이루어진다.
			}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx06 {
	public static void main(String[] args) {
		Thread06 th01 = new Thread06();
		th01.start(); //스레드 시작
		
		String cityName = JOptionPane.showInputDialog("도시이름 입력 : ");
		System.out.println("입력한 도시이름 : " + cityName);
	}
}
