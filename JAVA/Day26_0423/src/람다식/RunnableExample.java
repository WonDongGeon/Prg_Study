package 람다식;
/* 자바 내장 함수형 인터페이스인 Runnable은 자바 8버전에서 @FunctionalInterface로 정의 되어있어서 
 * 이 인터페이스로 람다식을 구현할 수 있다.
 * 즉 추상메서드가 딱 하나만 온다. 그것이 바로 run()이다. 결국 멀티스레드를 람다식 문법으로 구현할 수 있다.
 * 
 * 문제1) 함수형 인터페이스인 Runnable를 사용하면 람다식 익명객체를 구현할 수 있다.
 * 그러므로 스레드의 스케줄링 메서드와 람다식 문법을 활용해서 1초간격으로 10부터 1까지 카운터 되는 스레드 예제를
 * for 반복문을 사용해서 구하는 코드를 만들어 보자.
 */
public class RunnableExample {
	public static void main(String[] args) {
		//1번 문제 풀이
		Runnable run = () -> {
			for(int i = 10; i >= 1; i-- ) {
				System.out.println(i);
				try {
					Thread.sleep(1000); // 1초 간격으로 작동(1초간 일시정지)
				}catch(InterruptedException ie) {ie.printStackTrace();}
			}
		}; //람다식 익명객체 구현
		Thread th = new Thread(run);
		th.start(); // 스레드 시작
		
		/*문제2) Runnable 자손인 Thread 내장클래스와 for반복문, 스케줄링 메서드를 활용해서 람다식 문법으로 
		 * 동시에 1부터 10까지 카운터 되는 스레드 프로그램을 만들어 보자. 위의 스레드와 동시 카운터 작업이 이루어 진다.
		*/
		Thread th2 = new Thread( () -> {
			for(int i = 1;  i <= 10; i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ie) {ie.printStackTrace();}
			}
		}); //Thread 클래스로 람다식 익명객체 구현2
		th2.start();
	}
}
