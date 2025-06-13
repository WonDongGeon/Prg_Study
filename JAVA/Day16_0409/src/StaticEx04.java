/* static 키워드로 정의된 메서드를 정적메서드라고 한다. 정적메서드는 해당클래스로 직접 접근 가능하다.
 */
class St04 {
	private static int a = 10; //정적변수
	private int b = 20; //인스턴스 변수
	
	public static void setA(int new_a) {
		a = new_a;
	} //정적메서드 setA()정의
	
	public static int getA() {
		return a;
	} // 정적메서드 getA()정의
}
public class StaticEx04 {
	public static void main(String[] args) {
		System.out.println(St04.getA());
		
		St04 s01 = new St04();
		St04 s02 = new St04();
		
		s01.setA(1000); //생성된 객체로도 정적메서드 호출가능하다.
		int res01 = St04.getA();
		System.out.println(res01);
		System.out.println(s02.getA());
	}
}
