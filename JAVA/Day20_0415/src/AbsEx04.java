/* 변수를 final로 선언하면 수정할 수 없는 변수 즉 상수가 된다. 상수명은 관례적으로 영문대문자로 하고, 선언과 동시에 초기화를 해야 한다.
 */
class FinalMember {
	final int ABC =10;
	
	public void setA(int a) {
		//ABC = a; //ABC는 상수라서 수정할 수 없다.
	}
}
public class AbsEx04 {
	public static void main(String[] args) {
		
	}
}
