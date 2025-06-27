package reboard;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReBoardService {
	
	//OracleReBoardDao dao;
	//@Autowired(required = false)
	@Autowired
	//@Qualifier("oracleReBoardDao") //여러개의 빈이 있을 경우 빈 선택 어노테이션
	ReBoardDAO dao; //유연한 결합을 위해서 인터페이스 사용

	public PageList getPageList(int requestPage) {
		try {
			PageList pageList =new PageList.PageListBuilder()
			.totalCount(dao.count())
			.pagePerCount(10)
			.build();
			
			//-----------------------------------------------------------
			int totalPage=0;
			if((pageList.getTotalCount()%pageList.getPagePerCount()) == 0){
				totalPage=pageList.getTotalCount()/pageList.getPagePerCount();
			}else{
				totalPage=(pageList.getTotalCount()/pageList.getPagePerCount())+1;
			}
			pageList.setTotalPage(totalPage);
			
			//-----------------------------------------------------------
			pageList.setCurrentPage(requestPage);
			int startnum=((requestPage-1)*pageList.getPagePerCount())+1;
			int endnum=requestPage*pageList.getPagePerCount();
			
			//-----------------------------------------------------------
			int startPage=((requestPage-1)/5 * 5) + 1;
			int endPage=startPage + (5-1);
			if(endPage>totalPage) endPage=totalPage;
			pageList.setStartPage(startPage);
			pageList.setEndPage(endPage);
			
			//-----------------------------------------------------------
			boolean isPre=requestPage>5 ? true : false;
			boolean isNext=endPage<totalPage ? true : false;
			pageList.setPre(isPre);
			pageList.setNext(isNext);
			//db에 있는 필드 모두를 가지고 오는 명령
			List<ReBoard> list=dao.findAll(startnum, endnum);
			
			//-----------------------------------------------------------
			//페이지에 표시할 데이터는 BoardList
			List<ReBoardList> boardlists=new ArrayList<ReBoardList>();
			for(ReBoard board:list) {
				ReBoardList boardlist
				=new ReBoardList(
						board.getId(), 
						board.getTitle(), 
						board.getAuthor(), 
						board.getCreatedate(), 
						board.getAttachment(), 
						board.getViewcnt(),
						board.getTab());
				boardlists.add(boardlist);
			}
			pageList.setList(boardlists);
			return pageList;//정보를 리턴
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}

	public void write(ReBoardForm form, MultipartFile file) {
		
		//파일 저장시 파일 저장 위치
		String path ="D:\\storage\\";
		String filename=file.getOriginalFilename();
		String fullname=path+filename; // 풀네임
		
		try {
			file.transferTo(new File(fullname)); //파일 저장
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//폼에서 전송된 값과 파일의 이름을 데이터베이스 객체로 전달하여 저장하는 작업
		ReBoard reboard = new ReBoard.ReBoardBuilder()
				.title(form.getTitle())
				.content(form.getContent())
				.author(form.getAuthor())
				.attachment(filename)
				.build();
		dao.save(reboard);
	}

	public ViewPage getViewPage(int id) {
		dao.viewcntup(id);
		//뷰정보 요청하는 코드 작성
		ReBoard reboard = dao.findById(id);
		//생성날짜로 할지 업데이트날짜로 할지 정하기
		ViewPage page = new ViewPage.ViewPageBuilder()
				.id(reboard.getId())
				.title(reboard.getTitle())
				.content(reboard.getContent())
				.author(reboard.getAuthor())
				.createdate(reboard.getCreatedate())
				.updatedate(reboard.getUpdatedate())
				.attachment(reboard.getAttachment())
				.viewcnt(reboard.getViewcnt())
				.tab(reboard.getTab())
				.build();
		/*
		 * if(reboard.getUpdatedate() == null) { // 수정 날짜가 없는 경우
		 * page.setCreatedate(reboard.getCreatedate()); }else { // 수정 날짜가 있는 경우
		 * page.setUpdatedate(reboard.getUpdatedate()); }
		 */
		return page;
	}

	public void reply(ReplyBoardForm form, MultipartFile file) {
		//파일 저장시 파일 저장 위치
				String path ="D:\\storage\\";
				String filename=file.getOriginalFilename();
				String fullname=path+filename; // 풀네임
				
				try {
					file.transferTo(new File(fullname)); //파일 저장
				}catch (Exception e) {
					e.printStackTrace();
				}
				//폼에서 전송된 값과 파일의 이름을 데이터베이스 객체로 전달하여 저장하는 작업
		ReBoard reboard = new ReBoard.ReBoardBuilder()
				.title(form.getTitle())
				.content(form.getContent())
				.author(form.getAuthor())
				.attachment(fullname)
				.parentid(form.getParentid())
				.tab(dao.findById(form.getParentid()).getTab()+1)
				.build();
		dao.replySave(reboard);
	}

	public void delete(int id) {
		dao.delete(id);
	}	
	public void update(UpdateBoardForm form, MultipartFile file) {
		   String filename = file.getOriginalFilename();

		   // 파일을 안 올렸다면, 기존 파일명을 DB에서 조회
		   if (filename == null || filename.isEmpty()) {
		       ReBoard existing = dao.findById(form.getId()); // 기존 글 조회
		       filename = existing.getAttachment(); // 기존 파일명 유지
		   } else {
		       // 새 파일이 업로드된 경우 저장
		       String path = "D:\\storage\\";
		       String fullPath = path + filename;

		       try {
		           file.transferTo(new File(fullPath));
		       } catch (Exception e) {
		           e.printStackTrace();
		       }
		   }

		   // 최종적으로 모든 데이터를 포함해서 객체 생성
		   ReBoard reboard = new ReBoard.ReBoardBuilder()
		           .id(form.getId())
		           .title(form.getTitle())
		           .content(form.getContent())
		           .author(form.getAuthor())
		           .attachment(filename)  // 기존 또는 새 파일명
		           .build();
		    dao.update(reboard);
		}

	public UpdateViewPage getUpdateViewPage(int id) {
		//뷰정보 요청하는 코드 작성
		ReBoard reboard = dao.findById(id);
		//생성날짜로 할지 업데이트날짜로 할지 정하기
		UpdateViewPage updatepage = new UpdateViewPage.UpdateViewPageBuilder()
				.id(reboard.getId())
				.title(reboard.getTitle())
				.content(reboard.getContent())
				.createdate(reboard.getCreatedate())
				.updatedate(reboard.getUpdatedate())
				.author(reboard.getAuthor())
				.attachment(reboard.getAttachment())
				.tab(reboard.getTab())
				.build();
		/*
		 * if(reboard.getUpdatedate() == null) { // 수정 날짜가 없는 경우
		 * updatepage.setCreatedate(reboard.getCreatedate()); }else { // 수정 날짜가 있는 경우
		 * updatepage.setUpdatedate(reboard.getUpdatedate()); }
		 */
		return updatepage;
	}
}