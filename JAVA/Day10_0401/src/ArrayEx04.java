/* 2차원 배열
 */
public class ArrayEx04 {
	public static void main(String[] args) {
		int[][] score = new int[3][2]; // 3행 * 2열의 2차원 배열 score생성
		
		//score 2차원 배열 원소값 초기화
		score[0][0] = 10; score[0][1] = 20;
		score[1][0] = 30; score[1][1] = 40;
		score[2][0] = 50; score[2][1] = 60;
		
		//이중 for 반복문으로 2차원배열원소값을 일괄적으로 읽어옴
		int i, j; //반복문 제어변수
		for(i = 0; i < score.length; i++) { //2차원배열에서는 score.length는 행의 길이를 반환 => 3
			for(j = 0; j < score[i].length; j++) { // 2차원배열에서 score[i].length는 각 행의 열의 길이 2
				System.out.print(" " + score[i][j]);
			}// inner for
			System.out.println(); // 줄바꿈 => 개행
		} //outer for
	}
}
