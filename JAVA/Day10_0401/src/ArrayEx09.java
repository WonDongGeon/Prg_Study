/* 배열 원소 최대값, 최소값 구하기 */ 
public class ArrayEx09 {

	public static void main(String[] args) {	
		int[] score = {95, 96, 97, 93, 92};
		
		int max = score[0]; //첫번째 배열원소값을 최대값으로 초기화
		int min = score[0]; //배열의 첫번째 원소값을 최소값으로 초기화
		
		/* 문제) 배열의 최대값, 최소값을 구하는 나머지 코드를 for반복문과 if else if 다중 조건문을 사용해서 완성해 보자.
		 */
		
		for(int i = 0; i < score.length; i++) {
			if(score[i] > max) {
				max = score[i];
			} else if(score[i] < min) {
				min = score[i];
			}
		}
		System.out.print("최대값 : " + max + ", 최소값 : " + min);
	}

}
