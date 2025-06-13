/* 배열주소 범위를 벗어난 예외 오류 ArrayIndexOutofBoundsException을 발생
 */
public class ArrayEx05 {
	public static void main(String[] args) {
		int[] score = new int[5]; //배열 크기가 5인 score 배열 생성
		int k = 1;
		
		score[0] = 100;
		score[1] = 90;
		score[k+1] = 95;
		score[3] = 99;
		score[4] = 98;
		
		int tmp = score[k+2] + score[4]; // 99+98
		
		//for반복문으로 배열의 모든 원소값을 출력
		for(int i = 0; i < score.length; i++) {
			System.out.printf("score[%d] : %d%n", i , score[i]);
		}
		System.out.printf("tmp = %d%n", tmp);
		System.out.printf("score[%d] : %d%n", 7, score[7]); // 배열주소 인덱스 번호 범위를 벗어나서 예외 오류가 발생
	}
}
