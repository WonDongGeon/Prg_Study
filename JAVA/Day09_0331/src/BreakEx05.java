/* while무한루프문을 사용해서 누적합이 100을 초과할 때 무한루프문을 종료시키고 반복문 제어변수와 누적합을 출력시킨다.
 * 
 */
public class BreakEx05 {
	public static void main(String[] args) {
		int i = 0;
		int sum = 0; //반복문 제어변수와 누적합을 저장할 변수
		while(true) {
			if(sum > 100) {
				break; // 무한루프문 종료
			}
			++i;
			sum += i; //누적합
		} // 무한루프문
		System.out.printf("i=%d%n", i);
		System.out.printf("sum=%d%n", sum);
		
	}

}
