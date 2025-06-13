/*
 * 07장 제어문의 다양한 활용.pdf No.10 5번 문제
 * 스타(*)로 역삼각형을 출력하는 프로그램을 작성하시오.(Ex07_05.java-> 이중 for)
 */
public class Ex07_05 {
	public static void main(String[] args) {
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("* ");
			} // inner for
			System.out.println();
		} // outer for
	}
}
