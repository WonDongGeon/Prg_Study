//for 반복문에서 초기치, 조건식이 각 2개 나오고, 이중 for 반복문
public class GuardEx08 {

	public static void main(String[] args) {
		/*
		 * for(int i = 1, j = 10; i <= 10; i++, i--) { System.out.printf("%d \t %d%n",
		 * i, j); } System.out.println("\n ===================> \n");
		 */
		
		// 이중 for 반복문
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.print(" *");
			}//inner for(안쪽 for)
			System.out.println(); //줄바꿈
		}//outer for(바깥 for)
	}
}
