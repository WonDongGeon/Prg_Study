/* 멀티 스레드의 스케줄링 메서드 중 sleep() 과 interrupt()등에 대해서 살펴본다.
 * 
 */
import javax.swing.JOptionPane;
class Thread08 extends Thread {
	@Override
	public void run() {
		int i = 10;
		while(i != 0 && !isInterrupted()) {
			//isInterrupted()메서드는 스레드의 interrupted 된 상태를 boolean 타입을 반환한다.
			System.out.println(i--); // 1초 간격으로 카운트 다운
			
			try {
				Thread.sleep(1000); //1초간 일시정지 지연 => 1초 간격으로 작동
			}catch(InterruptedException e) {
				//interrupt()메서드가 호출되면 InterruptedException 예외 오류가 발생하면서 스레드의 interrupted 상태를
				//다시 false로 자동 초기화
				interrupt(); //interrupt()메서드를 호출하면 스레드의 interrupted 상태를 false에서 true로 초기화 되어서
				// 카운터가 중단
			}//try~catch
		}//while
		System.out.println("카운터가 종료되었습니다.");
	}//run()
}
public class ThreadEx08 {
	public static void main(String[] args) {
		Thread08 th = new Thread08();
		th.start();
		
		String name = JOptionPane.showInputDialog("이름 입력 : ");
		System.out.println("입력한 이름 : " + name);
		th.interrupt(); //interrupt()메서드를 호출하면 스레드의 interrupted 상태를 false에서 true로 초기화
		System.out.println("isInterrupted() boolean타입 상태 : " + th.isInterrupted());
	}
}
