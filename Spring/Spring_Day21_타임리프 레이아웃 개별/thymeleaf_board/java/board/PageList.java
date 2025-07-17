package board;

import java.util.Date;
import java.util.List;

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
public class PageList {
	private int currentPage; //현재페이지
	int totalCount;          //전체글의 수
	int pagePerCount=10;     //페이지당 글의 수
	int totalPage;           //전체페이지
	//private int startnum;    //글시작번호
	//private int endnum;      //글끝번호 
	private int startPage;   //네비게이트 시작번호
	private int endPage;     //네비게이트 끝번호
	private boolean isPre;   //네비게이트 이전표시여부 getPre(),setPre(); ->is함수는 is가 제거된상태에서 처리
	private boolean isNext;  //네비게이트 다음표시여부 getNext(),setNext();
	List<BoardList> list;    //게시판 페이지 리스트
	}