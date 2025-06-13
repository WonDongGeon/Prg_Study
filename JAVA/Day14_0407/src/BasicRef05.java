/* changeDate(MyDate05 t) {} 메서드 매개변수 타입이 참조타입인 MyDate05이다. 이런 경우는
 * 객체 주소를 공유해서 값도 함께 변경할 수 있다.
 * 
 */
class MyDate05 {
	int year = 2024;
	int month = 6;
	int day = 30;
}
class ReMethod {
	void changeDate(MyDate05 t) { //MyDate05 t = d;가 된다. t와 d는 같은 d객체주소를 가리킨다.
		t.year = 2025; t.month = 4; t.day = 7;
	}
}
public class BasicRef05 {
	public static void main(String[] args) {
		ReMethod rm = new ReMethod();
		MyDate05 d = new MyDate05();
		System.out.println("메서드 호출전 : " + d.year + "년 " + d.month + "월 " + d.day + "일");
		
		rm.changeDate(d); //d객체주소가 전달
		System.out.println("메서드 호출전 : " + d.year + "년 " + d.month + "월 " + d.day + "일"); //같은 주소를 공유해서 년월일이 변경된다.
	}
}
