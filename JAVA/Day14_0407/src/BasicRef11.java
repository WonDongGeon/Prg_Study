/* 참조타입 배열 매개변수
 * 
 */
public class BasicRef11 {
	static void printArr(int[] arr) {
		System.out.print("[");
		for( int i : arr ) {
			System.out.print(i);
			if(i != 4) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	static int sumArr(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {3,2,1,6,5,4}; //new int[]은 생략가능함
		printArr(arr);
		
		/* 문제01) 자바5에서 추가된 향상된 확장 for 반복문을 사용해서 다음과 같이 배열원소값이 출력되게 static void printArr(int[] arr) [] 
		 * 정적 메서드를 작성해 본다.
		 * 출력예) [3,2,1,6,5,4]
		 */
		
		int total = sumArr(arr);
		/* 문제02) 일반 for반복문을 사용해서 배열원소 총합을 구해서 반환한 다음 출력해 본다.
		 * 
		 */
		System.out.println("배열원소 총합 = " + total);
	}

}
