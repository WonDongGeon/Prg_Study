/*
 *   07장 제어문의 다양한 활용.pdf No.9 3번 문제
 *   1부터 100사이의 짝수를 출력하되 한 줄에 10 개씩 출력하시오. (Ex07_03.java->for,if,%)
2 4 6 8 10 12 14 16 18 20 
22 24 26 28 30 32 34 36 38 40 
42 44 46 48 50 52 54 56 58 60 
62 64 66 68 70 72 74 76 78 80 
82 84 86 88 90 92 94 96 98 100
 */
public class Ex07_03 {

	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
				if(i % 20 == 0) {
					System.out.println();
				} // inner if
			} // outer if
		} // for
	}
}
