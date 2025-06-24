package board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Writing {
	int id; // 글번호 (자동 증가)
	String title; // 제목
	String author; // 작성자 아이디
	Date createdate; // 작성일자(기본값 : 현재 시간)
	String content; // 내용(본문)
	String attachment; // 첨부 파일(BLOB 데이터 타입 사용)
	int viewcnt; // 조회수 (기본값 0)
	String type; // 게시판 종류 (예 : 공지사항 자유게시판 등)
}
