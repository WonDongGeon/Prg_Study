//16장 상속.pdf의 No.32 9번문제)
class A2 {
	@Override
	public String toString() {
		return "4";
	} 
	
} 
class B2 extends A2 {
	@Override
	public String toString() {
		return super.toString() + "3";
	} 
} 
public class Ex16_10 {
	public static void main(String[] args) {
		System.out.println(new B2( ));
	}
}
