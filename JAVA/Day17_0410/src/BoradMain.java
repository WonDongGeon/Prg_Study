/* lombok API가 설정된 DTO인 BoardDTO. JAVA를 업로드 해서 활용한다.
 * 
 */

import net.daum.dto.BoardDTO;

public class BoradMain {
	public static void main(String[] args) {
		BoardDTO board = new BoardDTO("홍길동", "게시판 글 제목입니다.", "게시판 글 내용입니다.");
		System.out.println("게시판 글쓴이 : " + board.getWriter());
		System.out.println("게시판 글 제목 : " + board.getTitle());
		System.out.println("게시판 글 내용 : " + board.getContent());
	}
}
