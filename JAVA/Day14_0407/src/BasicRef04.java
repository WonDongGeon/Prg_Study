/* 매개변수 타입이 기본타입이면 값이 전달되고, 객체주소는 공유하지 않는다. => 값에 의한 호출방식
 */
class Vm04 {
	void changeNumber(int y) { //int y매개변수 타입이 기본타입이다.
		y =10;
	}
}
public class BasicRef04 {

	public static void main(String[] args) {
		Vm04 vm = new Vm04();
		int x = 7;
		System.out.println("메서드 호출전 x = " + x); // 7
		vm.changeNumber(x);
		System.out.println("메서드 호출전 x = " + x); // 7
	}

}
