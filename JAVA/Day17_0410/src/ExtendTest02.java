/* 코드 재활용을 위한 상속 */
class Point2D { //extends Object가 생략됨
	private int x;
	private int y;
	
	// 전달인자가 없는 기본 생성자 생략
	
	public int getX() { //getter() 메서드
		return x;
	}
	public void setX(int x) { // setter() 메서드
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
class Point3D extends Point2D { // 상속 받으면 기본 생성자는 없음
	//private이 붙으면 상속받지 못함(접근을 못하게 하기 때문에)
	private int z;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
}
public class ExtendTest02 {
	public static void main(String[] args) {
		Point3D pt = new Point3D();
		pt.setX(10); //부모로부터 상속받아서 사용
		pt.setY(20); //부모로부터 상속받아서 사용
		pt.setZ(30); 
		
		System.out.println("x좌표값 : " + pt.getX()); //상속받아서 사용
		System.out.println("y좌표값 : " + pt.getY()); //상속받아서 사용
		System.out.println("z좌표값 : " + pt.getZ()); //상속받아서 사용
	}
}
