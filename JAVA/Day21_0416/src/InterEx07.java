/* Object 최고조상 클래스의 내장메서드 중에서 문자열 값 반환해 주는 toString()메서드를 오버라이딩 한다.
 * java.lang은 기본 패키지 경로이다.
 * 
 */
class Point07 { //extends Object 
	int x, y;
	
	Point07() {} //기본 생성자
	Point07(int x, int y) {
		this.x = x;
		this.y = y;
	}//생성자 오버로딩
	@Override
	public String toString() {
		String result; //지역변수
		result = "(x좌표값 : " + this.x + ", y좌표값 : " + y + ")";
		return result;
	}
}
public class InterEx07 {
	public static void main(String[] args) {
		Point07 pt = new Point07(100, 200);
		System.out.println(pt.toString());
	}
}
