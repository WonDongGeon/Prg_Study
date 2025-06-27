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
public class PageList {
	private int totalCount; // 전체 글 개수
	private int pagePerCount = 10; // 페이지당 글의 수
	private int totalPage; // 전체 페이지
	private int currentPage; //현재 페이지
	//private int startnum; //글시작번호
	//private int endnum; //글끝번호
	private int startPage; //네비게이트 시작번호
	private int endPage; //네비게이트 끝번호
	private boolean isPre; //네비게이트 이전표시여부
	private boolean isNext; //네비게이트 다음표시여부
	private List<ReBoardList> list; //게시판 페이지 리스트
}
