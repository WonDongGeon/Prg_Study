/* 16장 상속.pdf의 No.28 5번문제)
 * 컴파일 에러가 발생한다. 에러 이유에 대해서 주석문 처리한다.
 */
class TestSuper {
	int i;
	TestSuper(int i) {
		this.i = i;
	}
}
//class TestSub extends TestSuper{
	//기본 생성자 묵시적 제공
	//부모 클래스에서 생성자가 오버로딩 되었기 때문에 기본 생성자를 묵시적 제공하지 않는다.
	//그런데 자손에서 부모의 기본 생성자를 호출할려니 컴파일 에러가 발생한다.
	//자식 클래스에서 부모의 오버로딩된 생성자를 호출하는 방법이 제일 좋다
	//호출하기 위해서는 자식 클래스에서 생성자를 부모 클래스에서 오버로딩된 생성자에 맞게 오버로딩
	//시킨 후 오비로딩된 생성자에 부모 클래스에 있는 오버로딩된 생성자를 호출해준다.
//}
public class Ex16_06 {

	public static void main(String[] args) {
		//new TestSub();
	}

}
