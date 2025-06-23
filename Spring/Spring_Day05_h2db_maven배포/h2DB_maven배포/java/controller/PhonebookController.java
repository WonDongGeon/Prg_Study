package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.PhonebookService;
import vo.Phonebook;

@Controller
@RequestMapping("/phonebook")
public class PhonebookController  {
	
	@Autowired
	PhonebookService service;
	
	public PhonebookController() {
		System.out.println("phonebook controller!! /phonebook/");
	}
	
	//@RequestMapping("/phonebook/save") 
	@RequestMapping("save") 
	public String save() {
		return "save";
	}
	/*
	@RequestMapping("insertform")
	public String insertform() {
		return "insert";
	}*/
	
	//저장할 model이 없을 경우 void형으로 처리하며
	//url을 기준으로 폴더를 만들고 url명령어에 관한 jsp를 생성한다.
	@RequestMapping("insertform")
	public void insertform() {} // /WEB-INF/view/phonebook/insertform.jsp
	
	/*
	@RequestMapping("insert")
	public String insert(String name, String hp, String email, String memo) {
		System.out.println(name);
		System.out.println(hp);
		System.out.println(email);
		System.out.println(memo);
		return null;
	}*/
	
	@RequestMapping("insert")
	public String insert(Phonebook phonebook) {
		System.out.println(phonebook);
		int result = service.save(phonebook);
		if(result > 0) {
			return "success";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("list")
	public ModelAndView list() {
		//데이터요청 - 모델에 데이터저장 - 페이지 이동(data + view)
		List<Phonebook> list = service.list();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("list"); // /WEB-INF/views/list.jps
		return mv;
	}
	
	@RequestMapping("view")
	public ModelAndView view(@RequestParam(name="id") int id, ModelAndView mv) {
		//System.out.println(id);
		mv.addObject("pb", service.findById(id));
		mv.setViewName("view");
		return mv;
	}
	
	@RequestMapping("updateform")
	public ModelAndView updateform(int id, ModelAndView mv) {
		mv.addObject("pb", service.findById(id));
		mv.setViewName("phonebook/updateform");
		return mv; 
		// return 값이 없을 경우 view는 /WEB-INF/views(prefix) + url의 패턴 + .jsp(suffix)
		// ModelAndView를 만들고 리턴하지 않으면 페이지에 적용할 수 없음
	}
	
	@RequestMapping("update")
	public String update(Phonebook phonebook) {
		System.out.println(phonebook);
		//phonebook.setId(0); //error 404, 500 오류가 발생
		int result = service.update(phonebook);
		//오류발생시 0보다 작은값
		if(result < 1) {
			throw new CustomerException(); //오류발생시 프로그램은 여기서 종료
		}
		System.out.println("update성공!!");
		return "updateSuccess";
	}
	
	@RequestMapping("delete")
	public String delete(int id) {
		//오류발생시 0보다 작은값
		int result = service.delete(id);
		if(result < 1) {
			throw new CustomerException(); //오류발생시 프로그램은 여기서 종료
		}
		System.out.println("delete성공!!");
		return "deleteSuccess";
	}
}
