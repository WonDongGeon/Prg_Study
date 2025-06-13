/* 출금작업과 같은 특정작업이 이루어 질때는 syncronized 키워드로 동기화를 처리해야 하는대 이를 하지 않아서 출금 후 은행 잔액이
 * 음의 정수가 나오는 예제)
 */
class Account {
	private int balance = 1000; //계좌 잔액
	public int getBalance() {
		return balance;
	}//잔액 조회
	//동기화를 하지 않은 출금작업
	public void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			balance -= money;
		}//if
	}
}// 계좌 클래스
class RunnableEx01 implements Runnable {
	Account acc = new Account(); //계좌 객체 생성
	@Override
	public void run() {
			while(acc.getBalance() > 0) {
				int money = (int)(Math.random()*3+1)*100; //random()메서드는 0.0이상 1.0미만 사이의 실수숫자 난수를 발생
				// => *3하면 0.0이상 3.0미만 실수숫자 난수 => +1하면 1.0이상 4.0미만 => (int)형변환 하면 1이상 4미만 즉 1부터 3사이
				// 정수숫자 난수 발생 => *100하면 100,200,300사이 정수수자 난수
				acc.withdraw(money); //계좌로 부터 출금작업
				System.out.println("출금 후 잔애 = " + acc.getBalance());
			}
	}//스레드 문장 구현
}
public class TwoEx01 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx01(); // 업캐스팅
		new Thread(r).start(); //쓰레드 시작
		new Thread(r).start(); 
	}
}
