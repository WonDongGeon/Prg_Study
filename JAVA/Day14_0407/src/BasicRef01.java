/* 참조변수(레퍼런스)만 선언하고 객체주소를 대입안한 상태이면 해당 클래스 소속의 멤버변수(속성)에 접근 못한다.
 */
class Board01 {
	String writer; //게시판 글쓴이
	String title; //게시판 제목
	String cont; //게시판 내용
}
public class BasicRef01 {

	public static void main(String[] args) {
		Board01 b; //레퍼런스 변수만 선언(객체주소가 저장안됨) 
		//System.out.println("제목 : " + b.writer + ", 제목 : " + b.title + ", 내용 : " + b.cont); // 객체주소가 없기 때문에
		
		b = new Board01(); // 객체 주소가 대입된 참조변수
		System.out.println("제목 : " + b.writer + ", 제목 : " + b.title + ", 내용 : " + b.cont);

	}
}
