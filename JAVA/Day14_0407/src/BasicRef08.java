/* 기본타입 매개변수는 값만 전달된다. 객체주소를 공유하지 않아서 값도 공유 안된다.
 */
class Data08 {
	int x;
}
public class BasicRef08 {
	static void change(int x) {
		x = 1000;
		System.out.println("change() x = " + x); // 1000
	}
	static void change2(Data08 d) {
		d.x =1000;
		System.out.println("change() d.x = " + d.x); // 1000
	}
	public static void main(String[] args) {
		Data08 d = new Data08();
		d.x = 10;
		System.out.println("main() x = " + d.x);
		change(d.x); //
		System.out.println("change()메서드 호출 후 main()의 x = " + d.x); //10
		change2(d);
		System.out.println("change()메서드 호출후 main() d.x = " + d.x);
	}
}
