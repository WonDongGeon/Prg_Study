// 사용자 정의 정적메서드(정적메서드란 클래스의 객체를 생성하지 않고, 해당 클래스로 직접 호출하는 메서드를 말한다.)
// 정적메서드는 static키워드로 정의한다.)
public class MethodEx01 {
	static void sum(int n) {
		//sum() 메서드 앞에 리턴타입이 없는 void형을 사용, 즉 반환 값이 없는 자료형이다.
		//int n을 매개변수 또는 전달인자라고 함.
		int i;//반복문 제어변수
		int total = 0; //누적합을 저장할 변수 => 지역변수이다. 지역변수는 선언과 동시에 초기화 과정을 해야 한다.
		
		for(i = 1; i <= n; i++) {
			total += i;
		}
		System.out.printf("1부터 %d까지의 누적합 : %d%n", n, total);
		System.out.println("\n ========================\n");
	}
	static void sum2(int count) {
		int i = 1;
		int total = 0;
		while(i < count) {
			total += i;
			i++;
		}
		System.out.printf("1부터 %d까지의 누적합 : %d%n", count, total);
		System.out.println("\n ========================\n");
	}
	public static void main(String[] args) {
		sum(10);
		sum2(100);
		/* 문제)리턴타입이 없는 void형으로 1부터 100까지의 누적합을 구하는 실행문장이 있는 sum2(int count) {} 정적메서드를 정의한다.
		 *  누적합을 구할 때는 while 반복문을 사용한다.
		 */
	}
}
