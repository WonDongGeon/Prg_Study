/* 2차원 배열원소값을 1차원 배열로 다시 1차원 배열을 일반변수로 가져오는 것을 자바 5에서 추가된 향상된 확장 for반복문을 이용한 경우 
 */
public class ObjectArrEx04 {

	public static void main(String[] args) {
		int[][] score = {
				{100, 100, 100},
				{20,20,20},
				{30,30,30},
				{40,40,40}
		}; //4행 3열의 총 12 원소값을 저장해서 초기화한 2차원배열 score생성
		
		int sum = 0; //배열원소 누적합
		
		//일반 이중 for반복문으로 score 2차원 배열원소값을 출력
		for(int i = 0; i< score.length; i++) { //score.length는 행의 길이를 반환 => 4
			for(int j = 0; j < score[i].length; j++) { //score[i].length는 각 행의 열의 길이를 반환 => 3
				System.out.printf("score[%d][%d] =  %d\n", i, j, score[i][j]);
			}
		}
		
		System.out.println("\n===========================>\n");
		
		
		for(int[] arr : score) {  //2차원 배열을 1차원 배열로 변경
			for(int a : arr) { //1차원 배열을 일반 변수로
				sum += a;
			}
		}
		System.out.printf("배열원소 누적합 = %d\n", sum);
		
	}
}
