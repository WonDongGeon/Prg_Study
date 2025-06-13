/* 배열의 총합과 평균을 구하는 예제 */
public class ArrayEx08 {
	public static void main(String[] args) {
		int sum = 0; //배열 원소 누적합
		double average = 0.0; //평균
		
		int[] score = {100, 88, 100, 100, 90};
		
		/* 문제) 자바 5에서 추가된 향상된 확장 for반복문을 사용해서 배열원소 충점을 구하고, score.length와 캐스팅 형변환 연산자
		 * 등을 활용해서 배열원소 값의 평균을 구해서 출력해 보자.
		 */
		
		for(int a : score) {
			sum += a;
		}
		average = (double)sum/score.length; // 캐스팅을 이용하여 자동형변환
		System.out.println("총점 : " + sum + ", 평균 : " + average);
	}
}
