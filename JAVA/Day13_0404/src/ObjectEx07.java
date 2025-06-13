/* 자바에서 OOP(Object-oriented Programming, 객체 지향 프로그래밍)을 사용하는 목적(이유)
 * 1. 높은 재 사용성
 * 2. 중복 코드 제거
 */
public class ObjectEx07 {
	public static void main(String[] args) {
		
		int[] numArr = new int[10];
		//배열원소값 초기화
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = i+1; //1~10까지 정수값으로 배열원소값 저장
		}
		//일반 for로 출력
		for(int i = 0; i < numArr.length; i++) {
			System.out.printf("%d ", numArr[i]);
		}
		
		System.out.println("\n ==================>\n");
		
		for(int i : numArr) {
			System.out.print(i + " ");
		} // 배열원소값을 출력할 때 마다 반복적인 코드가 이루어짐.
		
		System.out.println("\n ==================>\n");
		//객체지향 언어 OOP를 활용해서 반복적인 코드안함
		
		Arr07 arr =new Arr07();
		arr.printArr(numArr); //배열원소값을 출력할 때 마다 해당 메서드만 호출하면 된다.
		arr.printArr(numArr); //배열원소값을 출력할 때 마다 해당 메서드만 호출하면 된다.
	}
}
class Arr07 { 
	void printArr(int[] arr) {
		for(int a : arr) {
			System.out.printf(" %d ", a);
		}
		System.out.println("\n =====================> \n");
	}//printArr()
}