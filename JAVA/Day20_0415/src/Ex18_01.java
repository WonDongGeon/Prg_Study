// 18장.추상 클래스와 final.pdf No19 1번 문제)
abstract class Abs1 {
	int a = 10;
	String str = "Test";
	public abstract int getA();
	public String getStr() {
		return str;
	}
}
abstract class Abs2 extends Abs1{
	int b = 100;
	public abstract int getB();
}
class AbsMain extends Abs2 {
	@Override
	public int getB() {
		return b;
	}

	@Override
	public int getA() {
		return a;
	}
}
public class Ex18_01 {

	public static void main(String[] args) {
		AbsMain am = new AbsMain();
		System.out.println(am.getA());
		System.out.println(am.getB());
		System.out.println(am.getStr());
	}

}
