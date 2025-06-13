/* static import문
 * staic import문을 사용하면 static 멤버(정적변수, 정적메서드)를 호출할 떄 클래스 이름을 생략할 수 있다.
 * 그만큼 코드도 간결해 진다.
 * 
 */
import static java.lang.System.out;
import static java.lang.Math.*;
// java.lang은 기본 패키지 경로이다. 이것의 의미는 코드상에서 생략해도 
public class SuperEx03 {
	public static void main(String[] args) {
		out.println("난수 = " + random());
		out.println("원주율 = " + PI);
	}
}
