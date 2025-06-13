/* 클래스 소속의 멤버변수와 생성자(메서드) 소속의 매개변수(전달인자) 이름이 같은 경우 멤버변수 앞에 this.을 사용하지 않으면
 * 자바는 구분하지 못해서 값이 저장 안되는 문제점이 발생함.
 * 
 */
class MyDate05 {
	private int year;
	private int month;
	private int day;
	
	public MyDate05() {}
	public MyDate05(int new_year, int new_month, int new_day) {
		year = new_year; month = new_month; day = new_day;
	}
	public void setYear(int year) { // 값 저장 setter()메서드 정의
		year = year;  //왼쪽의 멤버변수와 오른쪽의 매개변수명이 같으면 자바는 구분못해서 값을 저장하지 못한다.
	}
	public void setMonth(int new_month) {
		month = new_month;
	}
	public void pr() {
		System.out.println(year + "년 " + month + "월 " + day + "일" );
	}
}
public class ConsEx05 {
	public static void main(String[] args) {
		MyDate05 md = new MyDate05(2024, 7, 1);
		md.pr();
		md.setYear(2025);
		md.pr();
		md.setMonth(4);
		md.pr();
	}
}
