/* 클래스 초기화 블록 static {}
 * 
 */
public class ConsEx12 {
	static int[] arr = new int[10]; //배열 크기가 10인 정적 배열
	
	static {
		/* 문제) 1부터 10까지의 정수 난수로 일반 for 반복문을 사용해서 정적배열 arr 배열원소값을 초기화 해보자.
		 * 
		 */
		for(int i = 0; i < arr.length; i++) {
			int n = (int)(Math.random() * 10) + 1; // random() 정적 내장 메서드는 0.0이상 1.0미만 사이의 실수 숫자 난수가
			//발생하고 * 10하면 0.0이상 10.0미만 =>(int)로 형변환 하면 반올림 하지 않고 소수점 이하는 버린다 .0이상 10미만 즉 0부터 9사이의
			//정수 숫자 난수가 발생 => +1 하면 결국 1부터 10사이 정수 숫자 난수로 초기화
			arr[i] = n;
		}
	} //클래스 초기화 블록
	public static void main(String[] args) {
		/* 문제) 자바 5에서 추가된 향상된 확장 for를 사용해서 arr 정적배열원소값을 출력해보자.
		 */
		new ConsEx12();
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}
