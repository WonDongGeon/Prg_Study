/* for 반복문을 사용한 7단과 1부터 10까지 누적합
 * 
 */
public class GuardEx05 {
	public static void main(String[] args) {
		//7단
		int i; //반복문 제어변수
		int guguDan =7;
		
		System.out.println("<<====="+guguDan+"======>>" );
		for( i = 1; i <= 9; i++) {
			System.out.println(guguDan +  " x " + i + " = " + (guguDan * i)); // *는 곱셈연산기호
		} // for
		
		System.out.println("\n =================== \n");
		
		int total = 0; //누적합
		
		//1부터 10까지 자연수 누적합
		for(i = 1; i<=10; i++) {
			total = total + i;
		}
		System.out.println("1부터 10까지 누적합 = " + total);
	}

}
