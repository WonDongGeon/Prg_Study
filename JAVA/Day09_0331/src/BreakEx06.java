/*
 * 문제) for반복문과 continue, if조건문을 사용해서 1부터 100까지 자연수 중에서 4의 배수만 제외하고 누적합을 구하는 프로그램
 */
public class BreakEx06 {
	public static void main(String[] args) {
		int i;
		int sum = 0;
		for(i = 1; i <= 100; i++) {
			if(i % 4 == 0) {
				continue;
			}
			sum += i;
		}
		System.out.println("누적합은 " + sum);
	}

}
