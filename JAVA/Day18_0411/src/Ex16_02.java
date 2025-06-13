/* 16장 상속.pdf의 No.20 1번문제)
 *1. 접근 권한이 다음과 같이 지정되어 있을 경우 문제가 발생하는 문장찾기.([ ] 안에 숫자가 기술되어 있다. [ ] 몇 번 문장이 잘못 된 것인지 번호를 기술.(Ex16_2.java)  
 [1] [5] [9]
 */
class Parent { 
	int a; // private로 지정되어있었기 때문에 Child에서 접근이 불가능하기 때문임 (즉 a 변수는 상속 받을 수 없게 됨)
	int b;
	protected int c; 
	public int d; 
} 
class Child extends Parent { 
	public Child(int a, int b, int c, int d){ // 생성자 오버로딩
		this.a=a; //[1] 
		this.b=b; //[2] 
		this.c=c; //[3] 
		this.d=d; //[4] 
	} 
	void func( ){ 
		System.out.println(a); //[5] 
		System.out.println(b); //[6] 
		System.out.println(c); //[7] 
		System.out.println(d); //[8] 
	} 
} 
public class Ex16_02 {

	public static void main(String[] args) {
		Child one=new Child(1, 2, 3, 4); 
		one.func( ); 
		System.out.println(one.a); //[9] 
		System.out.println(one.b); //[10] 
		System.out.println(one.c); //[11] 
		System.out.println(one.d); //[12]
	}

}
