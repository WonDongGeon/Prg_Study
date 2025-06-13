/*
 * 08장.제어문을 보조하는 보조 제어문.pdf No.13 1번문제)
 * 1부터 100사이의 자연수중에서 제일 큰 7의 배수를 구하는 프로그램을 작성하시오. (Ex08_01.java-> for,if,%)
 * 단 100부터 반복하지 말고 1부터 1부터 반복해서 구한다.
 */
public class Ex08_01 {

	public static void main(String[] args) {
		int i;
		int num = 0;
		for(i = 1; i <= 100; i++) {
			if(i % 7 == 0) {
				num = i;	
			}
		}
		System.out.println("제일 큰 7의 배수 : " + num);
		
		/*
		 * 08장.제어문을 보조하는 보조 제어문.pdf No.13 1번문제)
		 * 2번문제) 100부터 1까지 1씩 감소하면서 for반복문등을 활용하여 6의 배수중 최대값을 구하는 코드를 만들어 보자.
		 */
		
		int j;
		int numMax = 0;
		for(j = 100; j >= 1; j--) {
			if(j % 6 == 0) {
				numMax = j;
				break;
			}
		}
		System.out.println("제일 큰 6의 배수 : " + numMax);
		
	}
}

