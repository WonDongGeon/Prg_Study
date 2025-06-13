/* 2번째 멀티스레드 구현법)
 * 1. Runnable 인터페이스를 구현상속 받아서 스레드 프로그램을 만든다. 
 * 장점은 다중상속을 받을 수 있다.
 * 2. 단점으로는 Runnable을 구현 상속한 자손 클래스 객체로 start()메서드를 호출 못한다. 그래서 이 자손 객체를 Thread생성자
 * 인자값으로 전달해서 또 한번더 객체를 생성해서 start()메서드를 호출해야 한다. 이유는 start() 메서드가 Thread클래스 소속 메서드이기 
 * 때문이다.
 */
class Thread03 implements Runnable {

	@Override
	public void run() {
		for(int num = 1; num <= 5; num++) {
			for(int k=1; k<100000000; k++) {
				System.out.println(Thread.currentThread().getName() + " : " + num);
				//현재 실행중인 스레드 이름을 반환
			}
		}
	}//멀티스레드 문장 구현
}
public class ThreadEx03 {
	public static void main(String[] args) {
		Thread03 t01 = new Thread03();
		Thread03 t02 = new Thread03();
		Thread th01 = new Thread(t01, "첫번째 스레드");
		Thread th02 = new Thread(t02, "두번째 스레드");
		
		th01.start(); // 멀티스레드 시작
		th02.start(); // 두번째 스레드 시작
	}
}