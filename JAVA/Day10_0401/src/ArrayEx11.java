import java.util.Arrays;
public class ArrayEx11 {
	public static void main(String[] args) {
		int[] score = {-4, -1, 3, 6, 11};
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			int tmp = (int)(Math.random() * score.length); //random()메서드가 0.0이상 1.0미만 사이 실수숫자 난수 =>
			//score.length 배열크기는 5, *5하면 0.0이상 5.0미만 => (int)로 형변환 하면 0이상 5미만 결국 0부터 4사이 임의의 정수
			//숫자 난수가 발생
			arr[i] = score[tmp];
		}
		//내장 API로 출력
		System.out.println(Arrays.toString(arr)); //배열원소값을 문자열로 반환
		
		//일반 for로 출력
		for(int i = 0; i < arr.length; i++) {
			System.out.print("arr[" + i + "] : " + arr[i] + ", ");
		}
		System.out.println("\n====================>\n");
		
		//향상된 확장 for로 출력
		for(int b : arr) {
			System.out.print(" " + b);	
		}
	}
}
