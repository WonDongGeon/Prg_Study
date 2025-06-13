/* 스레드의 스케줄링 메서드의 suspend(), resume(), stop() 메서드는 교착상태가 발생해서 앞으로는 사용하지 않을 것을 권장하는
 * @Deprecated 애노테이션으로 설정되어 있다.
 * 
 */
class Thread09 implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName()); //현재 실행중인 스레드 이름을 반환
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
		}// 무한루프문
	}// run()
}
public class ThreadEx09 {
	public static void main(String[] args) {
		Thread09 th = new Thread09();
		Thread t = new Thread(th, "#");
		Thread t2 = new Thread(th, "##");
		Thread t3 = new Thread(th, "###");
		
		t.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			t.suspend();// 2초 뒤에 첫번째 쓰레드를 일시 정지
			
			Thread.sleep(2000);
			t2.suspend();// 2초 뒤에 첫번째 쓰레드를 일시 정지
		}catch(InterruptedException e) {
			
		}
	}
}
