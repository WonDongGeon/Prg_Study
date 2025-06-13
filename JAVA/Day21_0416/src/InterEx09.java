/* Object 최고 부모 클래스의 equals()메서드를 자손에서 오버라이딩을 해서 활용)
 * 
 */
class Point09 extends Object {
	int x, y;
	public Point09() {}
	
	public Point09(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) { // 업캐스팅
		/* 문제) if조건문과 형변환 유무 판단 연산자인 instanceof를 추가 코드해서 명시적인 다운캐스팅이 되게 해보자.
		 * 
		 */
		Point09 ptTmp = null;
		if(obj instanceof Point09) {
			ptTmp = (Point09)obj; //명시적인 다운캐스팅		
		}
		if((x == ptTmp.x) && (y == ptTmp.y)) {
			return true;
		} else {
			return false;
		}
	} //equals
}
public class InterEx09 {
	public static void main(String[] args) {
		Point09 pt01 = new Point09(10, 20);
		Point09 pt02 = new Point09(10, 20);
		
		if(pt01 == pt02) {
			System.out.println("두 레퍼런스가 같다");
		} else {
			System.out.println("두 레퍼런스가 다르다.");
		}
		
		if(pt01.equals(pt02)) {
			System.out.println("값이 같다.");
		} else {
			System.out.println("값이 다르다.");
		}
	}
}