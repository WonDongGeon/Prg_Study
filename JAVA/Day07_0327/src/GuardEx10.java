//이중 for반복문을 사용한 구구단 구하기
public class GuardEx10 {
	public static void main(String[] args) {
		
		//첫번쨰 구구단
		for(int i = 2; i <=9; i++) {
			System.out.println(">>" + i + "단<<");
			for(int j = i; j <= 9; j++) {
				System.out.printf("%d x %d = %d\n", i, j, i*j);
			}
			System.out.println("======================>");
		}
		
		//두번째 구구단
		int k = 2;
		while(k<=9) {
			System.out.print(k+"단\t");
			k++;
		}
		System.out.println(" \n========================>");
		/* 문제) 이중 for반복문을 사용해서 구구단 내용을 다음과 같이 출력되게 한다.
		 * 2*1 = 2 3*1=3..... 8*1= 8 9*1=9
		 */
		for(int i = 1; i <=9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.print(j+" * " + i+ " = " + j * i + " ");
			}
			System.out.println();
		}
	}
}
