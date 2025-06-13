/*	16장 상속.pdf의 No.21 2번문제)
 * 
 *
 * Parnet 클래스의 디폴트 생성자 호출
 * Child 클래스의 디폴트 생성자 호출
 * Parnet 클래스의 전달인자 3개짜리 생성자 호출
 * Child 클래스의 전달인자 3개짜리 생성자 호출
 */
class Parent2 { 
	protected int a, b, c; 
	public Parent2( ){ 
		System.out.println("Parnet 클래스의 디폴트 생성자 호출"); 
	} 
	public Parent2(int a, int b, int c){ 
		System.out.println("Parnet 클래스의 전달인자 3개짜리 생성자 호출"); 
		this.a=a; this.b=b; this.c=c; 
	} 
} 
class Child2 extends Parent2 { 
	public Child2( ){ 
		System.out.println("Child 클래스의 디폴트 생성자 호출"); 
	} 
	public Child2(int a, int b, int c){ 
		super(a, b, c); 
		System.out.println("Child 클래스의 전달인자 3개짜리 생성자 호출"); 
	} 
} 
public class Ex16_03 {
	public static void main(String[] args) {
		Child2 one = new Child2( ); 
		Child2 two = new Child2(10, 20, 30);
	}
}
