/* 배열 원소값을 총합과 평균을 구한다.
 */
public class ArrayEx02 {

	public static void main(String[] args) {
		int[] score = {100, 90, 80, 96, 100}; // 5개의 int타입 배열원소값을 직접 저장하면서 초기화함. score배열 생성
		int sum = 0; //배열원소 총합
		double avg = 0.0; //평균
		int i; //반복문 제어변수
		
		for(i = 0; i<score.length; i++) {
			sum += score[i]; //배열 원소 총합
		}
		avg = (double)sum / score.length; //double/int는 자동산술법에 의해서 double/double이 된다. 결국 몫과 나머지를 함께 구하는 평균
		
		System.out.printf("총점 = %d\n", sum);
		System.out.printf("평균 = %f\n", avg);
		
	}

}
