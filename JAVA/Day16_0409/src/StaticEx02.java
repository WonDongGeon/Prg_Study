/* 생성자를 통한 인스턴스 변수 초기화 => 생성자 오버로딩
 * 
 */
class Document {
	static int count = 0; // 정적변수
	String name = null; // 인스턴스 변수
	
	Document() { //기본 생성자
		this("제목없음"); //같은 클래스내의 다른 생성자를 호출
	}
	Document(String name) {
		this.name = name;
		System.out.println("문서 : " + this.name + "가 생성");
	}//생성자 오버로딩
}
public class StaticEx02 {

	public static void main(String[] args) {
		new Document();
		new Document("자바.txt");
		new Document();
		new Document();		
	}
}
