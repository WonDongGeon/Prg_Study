/* 생성자가 오버로딩 된 경우)
 * 생성자가 오버로딩이 되면 자바 컴파일러는 더 이상 기본 생성자를 묵시적 제공하지 않는다.
 * 
 */
class Board04 {
	private String title; //게시판 제목
	private String content; //게시판 내용
	
	// 더 이상 기본 생성자 제공 안함.
	
	public Board04(String new_title, String new_content) {
		title = new_title;
		content = new_content;
	} // 생성자 오버로딩됨
	
	public void print() {
		System.out.println("게시판 제목 : " + title + ", 게시판 내용 : " + content);
	}
	
}
public class ConsEx04 {
	public static void main(String[] args) {
		//Board04 b = new Board04(); // 기본 생성자를 호출할려다가 컴파일 에러 발생
		//b.print();
		
		Board04 b = new Board04("자바", "생성자");
		b.print();
	}
}
