/* 생성자가 오버로딩이 안되었을 때는 자바 컴파일러가 묵시적인 전달인자가 없는 기본 생성자를 제공합니다.
 * 하지만 오버로딩이 된 경우는 기본 생성자를 묵시적 제공하지 않는다. 그것에 대한 에러가 예제
 * 
 */
class Data08 {
	int value;
	
	// 기본 생성자 묵시적 제공 안함
	
	Data08(int value) {
		this.value = value;
	}//생성자 오버로딩
	
	void print() {
		System.out.println("value = " + value);
	}
}
public class ConsEx08 {
	public static void main(String[] args) {
		//Data08 d = new Data08(); //기본 생성자 호출할려다가 컴파일 에러가 발생
		//d.print();
	}
}
