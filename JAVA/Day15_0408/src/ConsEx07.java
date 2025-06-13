/* 같은 클래스내에서 오버로딩 된 다른 생성자를 호출할려면 this()를 사용한다. (굳이 필수는 아님)
 */
class MyDate27 {
	private int year;
	private int month;
	private int day;
	
	public MyDate27() {
		this(2025,4,1); //같은 클래스 내에서 전달인자 3개짜리 오버로딩 된 생성자를 호출
	}
	public MyDate27(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day  = day; // 생성자의 주된 기능 멤버변수 초기화
	} // 생성자 오버로딩
	public void print() {
		System.out.println(year + "년 " + month + "월 " + day + "일 ");
	}
}
public class ConsEx07 {
	public static void main(String[] args) {
		MyDate27 md01 = new MyDate27();
		md01.print();
		MyDate27 md02 = new MyDate27(2025, 4, 8); // 오버로딩 생성자 호출
		md02.print();
	}

}
