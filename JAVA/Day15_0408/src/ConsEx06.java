/* 생성자 또는 메서드 내에서 멤버변수와 매개변수명이 같은 경우는 이를 구분하기 위해서 멤버변수명 앞에 this.붙여서 값을 저장되게 만든다.
 * 
 */
class MyDate26 {
	private int year;
	private int month;
	private int day;
	
	public MyDate26() {}
	
	public MyDate26(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void print() {
		System.out.println(year + "년 " + month + "월  " + day + "일" );
	}
}
public class ConsEx06 {

	public static void main(String[] args) {
		MyDate26 md = new MyDate26(2024, 7, 25);
		md.print();
		md.setYear(2025);
		md.setMonth(4);
		md.print();
	}

}
