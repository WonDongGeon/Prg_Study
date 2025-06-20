package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Phonebook;

public class FrontController implements Controller  {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Phonebook Controller!!");
		ModelAndView mv = new ModelAndView();
		
		//modeld은 전송할 데이터를 저장할 객체
		mv.addObject("data", "1234");
		//view는 데이터를 이용하여 화면을 표시할 페이지
		
		Phonebook pb = new Phonebook();
		pb.setId(1);
		pb.setName("김길동");
		pb.setEmail("010-1111-1111");
		pb.setMemo("친구");
		mv.addObject("phonebook", pb);
		//view는 데이터를 이용하여 화면을 표시할 페이지
		//mv.setViewName("/WEB-INF/views/view.jsp");
		//viewResolver적용시
		mv.setViewName("view");
		return mv;
	}
}
