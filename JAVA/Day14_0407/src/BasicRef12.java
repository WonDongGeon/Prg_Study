/* 전달인자 개수가 다른 메서드가 오버로딩 된 경우 기본타입 매개변수와 참조타입 배열 매개변수의 차이점 등
 * 
 */
public class BasicRef12 {
	int add(int a, int b) {
		return a + b;
	}
	void add(int a, int b, int[] result) {
		result[0] = a + b;
	} // 매개변수 인 전달인자 개수가 다른 메서드 오버로딩
	public static void main(String[] args) {
		BasicRef12 br = new BasicRef12();
		
		int re =br.add(3, 5);
		System.out.println("3 + 5 = " + re);
		
		int[] arr = {0};
		br.add(3, 5, arr); //arr과 result가 같은 배열주소를 가리킨다, 그래서 첫번째 배열원소값이 메서드 호출후 0에서 8로 변경됨.
		System.out.printf("arr[0] 배열원소값 = %d\n", arr[0]);
	}
}
