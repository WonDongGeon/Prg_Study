/* 11장. 클래스와 객체.pdf No.13의 1번 문제)
 * 다음은 하나의 속성(변수 x)을 갖는 Thing 클래스입니다. 다음 예제에서 문제점을 발견하고 이를 수정해 봅시다
class Thing{
	private int x;
} 
public class ThingTest01 {
	public static void main(String[] args) { 
		Thing thing1; 
		thing1=new Thing(); 
		thing1.x=10; 
		System.out.println(thing1.x);
	} 
}
 */
class Thing01 {
		private int x; //private을 없애는 방법도 있음 왜냐하면 private으로 외부에서 접근을 못하게 막하서 없애면 제약이 사라지기 때문임.
		public void setThing(int x) {
			this.x = x;
		}
	    public int getThing() {
	    	return x;
	    }
}	
public class ThingTest01 {
	public static void main(String[] args) {
			Thing01 thing1; 
			thing1=new Thing01(); 
			/*
			 * thing1.x=10;
			 * System.out.println(thing1.x);
			 */
			thing1.setThing(10);
			System.out.println(thing1.getThing());	
	} 
}
