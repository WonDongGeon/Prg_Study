/*	레퍼런스 변수를 선언하고 null만 대입된 상태에서 사용하며 NullPointerException 예외 오류가 발생한다.
 * 
 */
class MyDate07 {
	int year = 2025;
	int month = 4;
	int day = 7;
}
public class BasicRef07 {
	public static void main(String[] args) {
			MyDate07 d = null;
			//System.out.println(d.year + "년 " + d.month + "월 " + d.day + "일");'
	}
}
