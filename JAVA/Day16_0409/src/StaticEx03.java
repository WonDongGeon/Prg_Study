/* 인스턴스 변수와 정적변수의 차이점)
 * 
 */
class St03 {
	static int a =10; //static으로 정의된 변수 a를 정적변수라고 한다. 정적변수는 St03.a로 해당클래스로 접근한다.
	int b = 20;
	/* 클래스 소속 멤버변수(속성 => 필드) 종류)
	 * 정적변수와 인스턴스 변수
	 * 
	 */
}
public class StaticEx03 {
	public static void main(String[] args) {
		System.out.println("St03.a = " + St03.a); // 좋은 방법
		
		St03 s01 = new St03();
		St03 s02 = new St03();
		
		System.out.println("s01.a = " + s01.a + "\t" + "s02.a = " + s02.a); //생성된 객체로 정적변수 접근가능 : 좋지 않은 방법
		System.out.println("s01.b = " + s01.b + "\t" + "s02.a = " + s02.b); 
		
		s01.a = 1000;//정적변수 a값은 생성된 객체에 의해 공유됨
		System.out.println("s01.a = " + s01.a + "\t" + "s02.a = " + s02.a);
		
		s01.b =200; //인스턴스 변수는 생성된 객체마다 따로 관리된다. 즉 주소값이 다르다. 그러므로 다른값을 가진다.
		System.out.println("s01.b = " + s01.b + "\t" + "s02.a = " + s02.b); 
	}

}
