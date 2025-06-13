/*
 * 06. 반복문. pdf No.20쪽 3번 문제 풀이
 * 문제 : 10부터 1사이의 짝수를 10, 8, 6, 4, 2로 출력하는 프로그램을 작성하시오. (주의사항은 2출력하고 ,가 출력 안되어야 한다.)
 */
public class Ex06_03 {
	public static void main(String[] args) {
		int i =10;
		while(i >= 1) {
			if(i % 2 == 0) {
				System.out.print(i);
			} else if (i == 1) {
				System.out.print("");
			} else {
				System.out.print(", ");
			}
			i--;
		}
		
		System.out.println();
		
		int j = 10;
		while(j >= 4) {
			System.out.print(j+", ");
			j -= 2;
		} // 나올 때 j는 2임
		System.out.print(j);
	}
}
