package reboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.Getter;

@Controller
@RequestMapping("/reboard")
public class ReBoardController {
	
	@Autowired(required = false)
	ReBoardService service;
	
	//http://localhost:8888/reboard/list?requestPage=1;
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(defaultValue = "1") int requestPage, ModelAndView mv) {
		//페이지 정보가 있고, 페이지정보를 출력할 view jsp를 설정하는 객체(ModelAndView)
		//ModelAndView mv = new ModelAndView();
		mv.addObject("pageList", service.getPageList(requestPage));
		mv.setViewName("list");
		return mv;
	}
	
	//http://localhost:8888/reboard/writeform
	@RequestMapping("writeform")
	public String writeform() {
		return "writeform"; // /WEB-INF/views/writeform.jsp
	}
	
	//multipart/form-data전송시 입력값에 설정을 추가
	//form 객체는 
	@RequestMapping("write")
	public String write(@ModelAttribute ReBoardForm form, @RequestParam("attachment") MultipartFile file) {
		System.out.println(form);
		System.out.println(file.getOriginalFilename());
		
		//파일저장처리
		service.write(form, file);
		return "redirect:/reboard/list";
	}
	
	
	//http://localhost:8888/reboard/view?id=x
	@RequestMapping("view")
	public ModelAndView view(int id, ModelAndView mv) {
		System.out.println("------------------------");
		System.out.println(id);
		mv.addObject("page", service.getViewPage(id));
		mv.setViewName("view");
		return mv;
	}
	
	//댓글쓰기폼
	//http://localhost:8888/reboard/reply?id=x
	@RequestMapping("reply")
	public String reply(@RequestParam(name="id") int parentid, Model model) {
			model.addAttribute("parentid", parentid);
			//부모글의 제목, 댓글길이가 필요한 경우 데이터 획득
			model.addAttribute("parentid", parentid);
			model.addAttribute("title", service.getViewPage(parentid).getTitle());
			model.addAttribute("tab", service.getViewPage(parentid).getTab());
			return "reply"; 
			// /WEB-INF/views/reply.jsp(writeform.jsp복사)
	}
	
	//댓글처리(입력처리유사)
	//http://localhost:8888/reboard/reply
	@PostMapping("reply")
	public String reply(@ModelAttribute ReplyBoardForm form, @RequestParam("attachment") MultipartFile file) {
		System.out.println(form);
		System.out.println(file.getOriginalFilename());
		
		service.reply(form, file);
		return "redirect:/reboard/list";
	}
	
	
	//http://localhost:8888/reboard/updateform?id=x
	@RequestMapping("updateform")
	public ModelAndView updateform(@RequestParam(name="id") int id, ModelAndView mv) {
		mv.addObject("page", service.getUpdateViewPage(id));
		mv.setViewName("updateform");
		return mv;
	}
	
	//http://localhost:8888/reboard/update
	@RequestMapping("update")
	public String update(@ModelAttribute UpdateBoardForm form, @RequestParam("attachment") MultipartFile file) {
		service.update(form, file);
		return "redirect:/reboard/list";
	}
	
	//http://localhost:8888/reboard/delete?id=x
	@RequestMapping("delete") 
	public String delete(@RequestParam(name="id") int id) {
		service.delete(id);
		return "redirect:/reboard/list";
	}
	
	@GetMapping("img")
	public String img() {
		return "img";
	}
}
