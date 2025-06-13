/* 1. static 키워드로 정의된 변수 count를 정저겹ㄴ수라고 한다. 정적변수는 클래스 변수로서 해당클래스로 직접 접근 가능하다.
 *  초기화 하는 방법
 */
class Product {
	static int count = 0; // 명시적인 초기화 <- 정적변수
	int serialNo; //인스턴스 변수 => 생성된 객체마다 따로 관리한다.(생성된 객체마다 주소값이 다르다.)
	//명시적인 초기화를 안했지만 기본값 0으로 초기화
	{
		++count;// 개수를 카운터 (생성된 객체마다 값을 공유가능하다. => 누적 카운터)
		serialNo = count; // 인스턴스 변수 초기화
	} // 인스턴스 초기화 블록
	public Product () {} // 기본생성자 => 생성자 오버로딩이 안되었기 때문에 생략가능하다.
}

public class StaticEx01 {
	public static void main(String[] args) {
		Product p01 = new Product(); // 먼저 인스턴스 초기화 블록을 호출하고 그 다음에 생성자를 호출
		Product p02 = new Product();
		Product p03 = new Product();
		
		System.out.println("p01 제품번호(시리얼 번호) : " + p01.serialNo);
		System.out.println("p02 제품번호(시리얼 번호) : " + p02.serialNo);
		System.out.println("p03 제품번호(시리얼 번호) : " + p03.serialNo);
		System.out.println("총 생산대수 : " + Product.count);
	}
}
