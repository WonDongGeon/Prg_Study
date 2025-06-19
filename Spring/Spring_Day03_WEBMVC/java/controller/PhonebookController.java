package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("insertform")
	public String insertform() {
		return "insert";
	}
	
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
	public String insert(Phonebook pb) {
		System.out.println(pb);
		int result = service.save(pb);
		if(result > 0) {
			return "success";
		}else {
			return "error";
		}
	}
	@RequestMapping("list")
	public String list() {
		return null;
	}
	
	@RequestMapping("view")
	public String view() {
		return null;
	}
	
	@RequestMapping("updateform")
	public String updateform() {
		return null;
	}
	
	@RequestMapping("update")
	public String update() {
		return null;
	}
	
	@RequestMapping("delete")
	public String delete() {
		return null;
	}
}
