/* 배열원소값을 서로 바꾸는 예제 */
public class ArrayEx10 {

	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		// 배열원소값을 0~9로 초기화하고 출력
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = i; 
			System.out.println(" " + numArr[i]);
		}
		System.out.println("\n========================>\n");
		
		//배열원소값을 서로 바꿈
		for(int i = 0; i < 100; i++) {
			int n = (int)(Math.random() * 10); // random()메서드는 0.0이상 1.0미만 사이의 실수 숫자 난수를 발생 => * 10하면
			// 0.0이상 10.0이만 => (int)로 형변환 하면 소수점이라는 반올림 하지 않고 버린다. 0~9
			int tmp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp;
			
		}
		
		//일반 for로 출력
		for(int i = 0; i < numArr.length; i++) {
			System.out.print(" " + numArr[i]);
		}
		System.out.println("\n");
		
		//확장 for로 출력
		for(int i : numArr) {
			System.out.print(" " + i) ;
		}
		System.out.println("\n========================>\n");
	}

}
