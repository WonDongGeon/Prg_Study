/* 2차원 배열을 활용해서 과목별 총점, 개인별 총점, 개인별 평균을 구한다.
 * 
 */
public class ObjectArrEx05 {
	public static void main(String[] args) {
		int[][] score = {
				{100, 100, 100},
				{20,20,20},
				{30,30,30},
				{40,40,40},
				{50,50,50}
		}; // 5행 * 3열 2차원 배열 score 생성
		
		int korTotal = 0; // 국어 총점
		int engTotal = 0; // 영어 총점
		int mathTotal = 0; // 수학 총점
		
		System.out.println("번호	국어	영어	수학	총점	평균");
		System.out.println("==========================");
		
		for(int i = 0; i < score.length; i++) {
			int sum = 0; //개인별 총점
			double avg = 0.0; //개인별 평균
			
			korTotal += score[i][0];
			engTotal += score[i][1];
			mathTotal += score[i][2];
			
			System.out.printf("%3d", i + 1); //학생 번호 출력, %3d는 세자리 십진수 정수 표현이고, 오른쪽 기본 정렬이고 빈자리는 공백으로 채운다.
		
			for(int j = 0; j < score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%5d", score[i][j]); //2차원 배열 원소값 출력
			} // inner for
			
			avg = sum/(double)score[i].length; //score[i].length는 각 행의 열의 길이를 반환 => 3		
			// int/double은 자동산술법에 의해서 double/double로 자동 형변환 된다.
			
			System.out.printf("%5d %5.1f\n", sum, avg);
			/*%5.1f 십진수 실수 출력형태는 %전체자리수.소수점이하자리수f이다. 소수점을 포함한 전체자리수는 5이고 소수점 이하
			 * 자리수는 한 자리까지 표현한다.
			 */
			} //outer for
		System.out.println("\n==========================");
		System.out.printf("총점 : %3d %4d %4d%n", korTotal, engTotal, mathTotal);
	}
}
