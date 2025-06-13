/*
 * 배열이란 동일한 타입의 하나 이상 복수개의 원소값을 고정된 크기로 한꺼번에 저장하기 위해서 사용하는 것을 말한다.
 * new 키워드를 사용한 배열 생성법)
 * 타입[] 배열명 = new 타입[배열크기];
 */
public class ArrayEx01 {

	public static void main(String[] args) {
		int[] score = new int[5];
		score[0] = 100; //배열 주소 인덱스 번호는 1이 아닌 0부터 시작하는 것에 주의하길 바란다.
		score[1] = 90; // 2번째 배열 원소값으로 90을 저장
		score[2] = 99;
		score[3] = 89;
		score[4] = 97;
		
		System.out.printf("배열크기 = %d%n", score.length); // 배열 크기 인 배열원소개수는 배열명.length로 반환한다.
		
		//일반 for 반복문으로 배열원소값을 일괄적으로 출력
		for(int i = 0; i<score.length; i++) { // 배열 주소 인덱스 번호는 0부터 시작하니 반복문 제어변수 초기값도 0으로 함.
			System.out.println("score["+i+"] = " + score[i]); 
		}
	}

}
