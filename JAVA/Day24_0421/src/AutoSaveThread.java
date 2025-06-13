/* 데몬 스레드 : 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드 */
public class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용을 저장함");
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000); //1초 간격으로 save()메서드를 호출해서 AutoSaveThread 데몬 스레드 실행
			}catch(InterruptedException e) {
				break; //무한루프 종료
			}
		}// 무한 루프문
	}// run()
}
