/* 매개변수가 in[] x이면 이것은 배열이라서 참조타입 매개변수가 된다. 이것도 주소값을 공유할 수 있어서 배열원소값도 공유가능하다.
 * 
 */
public class BasicRef10 {

	static void change(int[] arr) { //참조타입 매개변수
		arr[0] = 1000; // 첫 번째 배열원소값을 1000으로 초기화
		System.out.println("change()메서드의 arr[0] : " + arr[0]);
	}
	public static void main(String[] args) {
		int[] x = {10};
		
		System.out.println("main()메서드의 x[0] = " + x[0]); //10
		change(x); //배열주소를 공유
		System.out.println("change()메서드 호출 후 x[0] = " + x[0]); //10
	}

}
