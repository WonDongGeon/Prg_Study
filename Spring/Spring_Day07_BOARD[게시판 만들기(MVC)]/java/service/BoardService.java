package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.BoardDAO;
import service.BoardList;
import service.PageList;
import controller.BoardForm;
import repository.BoardDAO;
import repository.OracleBoardDAO;
import vo.Board;

@Service
public class BoardService {
	
	@Autowired
	BoardDAO dao;
	
	public BoardService() {
		System.out.println("board service!!");
	}

	public PageList pageList(int requestPage) {
		try {
		PageList pageList =new PageList(); //전체정보를 담는 객체
		pageList.setTotalCount(dao.count());
		pageList.setPagePerCount(10);
		int totalPage=0;
		if((pageList.getTotalCount()%pageList.getPagePerCount()) == 0){
			totalPage=pageList.getTotalCount()/pageList.getPagePerCount();
		}else{
			totalPage=(pageList.getTotalCount()/pageList.getPagePerCount())+1;
		}
		pageList.setTotalPage(totalPage);
		
		pageList.setCurrentPage(requestPage);
		int startnum=((requestPage-1)*pageList.getPagePerCount())+1;
		int endnum=requestPage*pageList.getPagePerCount();
		
		int startPage=((requestPage-1)/5 * 5) + 1;
		int endPage=startPage + (5-1);
		if(endPage>totalPage) endPage=totalPage;
		pageList.setStartPage(startPage);
		pageList.setEndPage(endPage);
		
		boolean isPre=requestPage>5 ? true : false;
		boolean isNext=endPage<totalPage ? true : false;
		pageList.setPre(isPre);
		pageList.setNext(isNext);
		//db에 있는 필드 모두를 가지고 오는 명령
		List<Board> list=dao.findAll(startnum, endnum);
		//페이지에 표시할 데이터는 BoardList
		List<BoardList> boardlists=new ArrayList<BoardList>();
		for(Board board:list) {
			BoardList boardlist
			=new BoardList(
					board.getId(), 
					board.getTitle(), 
					board.getAuthor(), 
					board.getCreatedate(), 
					board.getAttachment(), 
					board.getViewcnt());
			boardlists.add(boardlist);
		}
		pageList.setList(boardlists);
		return pageList;//정보를 리턴
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int save(BoardForm form) {
		Board board=new Board();
		board.setTitle(form.getTitle());
		board.setContent(form.getContent());
		board.setAuthor(form.getAuthor());
		board.setAttachment(form.getAttachment());
		board.setType("일반게시판");
		return dao.save(board);
	}
}
