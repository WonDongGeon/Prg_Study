/* 부모의 멤버변수명과 동일한 이름을 가진 변수명을 자손에서 정의한 경우
 * 
 */
class Parent04 {
	protected int a = 10;
	protected int b = 20;
}
class Child04 extends Parent04 {
	protected int a = 40;
	protected int b = 50;
	protected int c = 30;
	
	public void pr() {
		System.out.println(this.a +  "\t" + this.b + "\t" + c); //변수명 앞에 this. 이 생략됨
		//this.a, this.b,  c라고 한 경우 자손에 정의된 변수명을 호출
		
		System.out.println("super.a = " + super.a + ", super.b = " + super.b); // 10, 20
		/* 부모와 자손에서 동일한 멤버변수명이 정의된 경우 부모로 부터 상속받은 멤버변수명을 호출할 때는 super.변수명으로 호출한다.
		 */
	}
}
public class ExtendTest04 {
	public static void main(String[] args) {
		Child04 ch04 = new Child04();
		ch04.pr();
	}
}
