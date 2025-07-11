package student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import student.service.StudentService;
import student.vo.Student;

@Controller
//@RequestMapping("/student") //왜 필없는가 ? beans:beans
public class StudentController {
	@Autowired
    private StudentService studentService;
	
	public StudentController() {
		System.out.println("컨트롤러 생성!!");
	}
	// http://localhost:8888/student/getList
	@RequestMapping("getList")
	public ModelAndView getList() {
		return null;
	}
	
	 @GetMapping("students")
	    public String getStudents(Model model) {
	        List<Student> students = studentService.getStudentsWithGrades();
	        model.addAttribute("students", students);
	        return "studentList"; // studentList.jsp 또는 studentList.html
	    }
}
