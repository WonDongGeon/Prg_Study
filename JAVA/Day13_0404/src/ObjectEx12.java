/* 자바 5에서 추가된 가변인자(Varages) 문법)
 * 전달인자 개수가 다른 메서드가 오버로딩 된 경우 그 개수만큼 메서드를 호출해야 한다.
 * 그만큼 코드라인이 길어진다. 이를 해결하기 위해서 자바 5에서 가변인자 문법이 추가되었다.
 * 형식은 int . . . arr이다 arr은 배열로 처리된다.
 * 
 */
class Mt12 {
	void prn(int ... arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(" " + arr[i]);
		}
		System.out.println();
	}
}
public class ObjectEx12 {
	public static void main(String[] args) {
		Mt12 mt12 = new Mt12();
		mt12.prn(10);
		mt12.prn(10,20,30);
	}
}
