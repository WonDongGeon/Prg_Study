/* 디폴트(default : 기본생성자) 생성자 특징)
 *  1. 기본 생성자는 전달인자가 없는 생성자를 말한다. 생성자가 오버로딩이 안된 경우는 자바 컴파일러가 묵시적인 기본 생성자를 제공한다.
 * 
 */
class MyDate23 {
	private int year; 
	private int month; 
	private int day;
	
	//기본 생성자 묵시적 생략됨
	
	public void pr() {
		System.out.println(year + "/" + month + "/" + day);
	}
}
public class ConsEx03 {
	public static void main(String[] args) {
		MyDate23 d = new MyDate23();
		d.pr();
	}
}
