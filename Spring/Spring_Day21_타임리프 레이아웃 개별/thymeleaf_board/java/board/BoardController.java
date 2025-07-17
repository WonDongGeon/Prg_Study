package board;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.HttpResource;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	public BoardController() {
		System.out.println("board contrller 객체생성!!");
	}
	// http://localhost:8888/board/list?requestPage=1
	@RequestMapping("list")
	//@GetMapping(value = "list")
	//@RequestMapping(value = "list",method = RequestMethod.GET )
	//문제사항:/board/list 주소에 requestPage가 없는 경우 오류발생
	public ModelAndView list(@RequestParam(value ="requestPage", defaultValue = "1" ) int requestPage, ModelAndView mv){
		//System.out.println(requestPage);
		//ModelAndView mv=new ModelAndView(); //파라메다로 적용하여 변수선언
		System.out.println(service.pageList(requestPage));
		PageList page=service.pageList(requestPage);
		mv.addObject("pageList", service.pageList(requestPage));
		mv.setViewName("list"); // /WEB-INF/views/list.jsp ->viewResolver등록
		return mv;
	}
	//http://localhost:8888/board/writeform
	@RequestMapping("writeform")
	public String writeform()
	{
		return "writeform";
	}
	
	@RequestMapping("write")
	public void write(BoardForm form,HttpServletResponse response){
		System.out.println(form);
		int result=service.save(form);
		if(result>0) {
		try {
			response.getOutputStream().write("<script>alert('입력성공!')</script>".getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
		try {
			response.getOutputStream().write("<script>alert('입력실패!')</script>".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//저장할객체는 ViewBoard.java
	@RequestMapping("view")
	public ModelAndView view(int id,ModelAndView mv){
		//view.jsp의 데이터정보확인 후 객체생성(BoardViewPage.java)
		mv.addObject("page", service.viewPage(id)); 
		mv.setViewName("view");
		return mv;
	}
	
	public ModelAndView updateform(int id){return null;}
	public String update(UpdateForm form){return null;}
	public String delete(int id){return null;}
}