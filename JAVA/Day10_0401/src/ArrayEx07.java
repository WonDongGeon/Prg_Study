/* 배열 복사 */
public class ArrayEx07 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		
		//배열 arr에 1부터 5까지 저장
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println("변경전 배열크기 : " + arr.length);
		
		//배열원소값 출력
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}
		
		int[] tmp = new int[arr.length*2]; //배열 크기를 2배로 증가
		
		//배열 arr에 저장된 값을 배열 tmp로 복사
		for(int i = 0; i < arr.length; i++) {
			tmp[i] = arr[i];
		}
		
		//arr = tmp; // 배열은 참조타입이다. 그러므로 우측의 tml배열주소가 arr에 대입되어서 기존 arr배열주소는 사라진다.
		//결국 arr은 tmp 배열주소를 가리킨다. 그래서 arr배열크기는 5가 아닌 10이된다.
		
		System.out.println("변경후 배열크기 = " + arr.length);
		
		/* 문제) 기존 일반 for반복문과 자바 5에서 추가된 향상된 확장 for 반복문을 사용해서 각각 arr 배열원소값을 출력하는
		 * 코드를 작성해보자
		 */
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print("arr[" + i + "] : " + arr[i] + " ");
		}
		
		System.out.println();
		
		for(int  i : arr) {
			System.out.print(i + " ");
		}
		
	}
}
