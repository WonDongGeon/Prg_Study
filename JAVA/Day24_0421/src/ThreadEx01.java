/* 멀티스레드 구현법 첫번째)
 * 1. Thread 클래스를 상속하는 법
 * 2. run()메서드를 오버라이딩을 해서 스레드 문장을 구현
 * 3. Thread 클래스를 상속받아서 스레드 프로그램을 만들면 단순한 것을 만들 수 있는 장점과, 단일 상속만 가능하다는 단점이 있다.
 * 
 */
class Thread01 extends Thread {
	Thread01(String name) { //생성자 오버로딩
		super(name); //부모클래스 오버로딩 된 생성자를 호출해서 스레드 이름을 반환
	}
	@Override
	public void run() {
		for(int num=1; num <=5; num++) {
			for(int k = 1; k < 100000000; k++); //스레드가 구현될 시간적 여유를 둔다.
			System.out.println(getName() + " : " + num); //getName()메서드로 스레드 이름을 반환
		}
	}//스레드 문장 구현
}
public class ThreadEx01 {
	public static void main(String[] args) {
		Thread01 th01 = new Thread01("첫번째 스레드");
		Thread01 th02 = new Thread01("두번째 스레드");
		th01.start(); //멀티스레드 시작되고 실행대기 상태에 잇다가 자기 차례가 되면 run()메서드를 자동호출해서 스레드
		// 실행상태가 된다.
		th02.start(); //두번째 스레드 시작
	}
}
