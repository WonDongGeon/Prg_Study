/* 주스레드 main, 3초후에 메인 주스레드가 종료되면 데몬 스레드인 AutoSaveThread도 따라서 자동종료된다. */
public class ThreadEx07 {
	public static void main(String[] args) {
		
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true); //데몬 스레드 지정, start()메서드를 호출하기 전 먼저 기술실행해야 예외 에러가 안난다.
		autoSaveThread.start(); //데몬 스레드 시작
		
		try {
			Thread.sleep(3000); //3초 뒤에 메인 주 스레드 종료
		}catch(InterruptedException e) {}
		
		System.out.println("메인 스레드 종료");
	}
}