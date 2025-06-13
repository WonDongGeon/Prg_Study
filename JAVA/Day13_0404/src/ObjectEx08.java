/* 자바 OOP에서 클래스 소속의 사용자 정의 메서드)
 * return 키워드로 값을 반환하는 메서드와 그렇지 않고 구구단을 출력하는 메서드
 * 
 */
class Obj07 {
	void print99Dan() {
		int i, j; // 반복문 제어변수이고 지역변수
		for(j = 1; j <=9; j++) {
			for(i = 2; i <= 9; i++) {
				System.out.print(i + " * " + j + " = " + j*i);
			}
		}
		System.out.println("\n ================= \n");
	} // 구구단 출력 메서드
	int add(int x, int y) {
		return x + y; //return 키워드에 의해서 해당 메서드를 호출한 곳으로 덧셈 결과값을 반환한다.
	}
}
public class ObjectEx08 {
	public static void main(String[] args) {
		Obj07 obj = new Obj07();
		obj.print99Dan();
		System.out.println("10 + 10 = " + obj.add(10,10));
	}

}
