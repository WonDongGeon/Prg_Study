package reboard;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
public class ReBoardList {
	private int id; // 글번호 (자동 증가)
	private String title; // 제목
	private String author; // 작성자 아이디
	private Date createdate; // 작성일자(기본값 : 현재 시간)
	private String attachment; // 첨부 파일(BLOB 데이터 타입 사용)
	private int viewcnt; // 조회수 (기본값 0)
	private int tab;
}
