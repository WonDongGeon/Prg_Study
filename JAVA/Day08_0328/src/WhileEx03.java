/* 1. for 반복문을 2번사용하여 짝수/홀수들의 누적합
 *  2. for 반복문안에 if, %(나머지) 연산을 활용해서 홀수/짝수들의 누적합
 */
public class WhileEx03 {
	public static void main(String[] args) {
		
		int  i; //반복문 제어변수
		int odd_tot, even_tot; //홀수 누적합, 짝수 누적합을 저장하는 변수 선언
		// 지역변수인 로컬변수는 선언과 동시에 반드시 초기화를 해야 한다.
		
		//짝수들의 누적합
		for(i = 10, even_tot = 0; i >= 2; i-=2) {
			even_tot += i;
		}
		System.out.println("짝수들의 누적합 = " + even_tot);
		
		//홀수들의 누적합
		for(i = 1, odd_tot = 0; i <=10; i+=2) {
			odd_tot = odd_tot + i;
		}
		System.out.println("홀수들의 누적합 = " + odd_tot);
		
		//for, if, %
		for(i = 1, odd_tot = 0, even_tot = 0; i <=10; i++) {
			if(i % 2 == 1) { //나머지가 1일때는 홀수일때 실행
				odd_tot += i;
			} else { //나머지가 2일때는 짝수일때 실행
				even_tot += i;
			}
		}
		System.out.printf("짝수들의 누적합 = %d%n", even_tot);
		System.out.printf("홀수들의 누적합 = %d%n", odd_tot);
	}
}
