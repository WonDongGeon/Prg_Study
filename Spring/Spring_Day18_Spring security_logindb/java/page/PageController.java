package page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController //restController는 데이터만 전송하는 컨트롤러
@Controller
public class PageController {
	
	//restController를 사용할 경우
	/*
	@GetMapping("/admin/index")
	public String adminIndex() {
		return "admin index 페이지입니다.";
	}
	
	@GetMapping("/user/index")
	public String userIndex() {
		return "user index 페이지입니다.";
	}
	*/
	
	//controller를 사용할 경우 viewresolver적용이 됨
	@GetMapping("/admin/index")
	public String adminIndex() {
		return "admin/index"; //page폴더의 admin폴더의 index.jsp
	}
	
	@GetMapping("/user/index")
	public String userIndex() {
		return "user/index"; //page폴더의 user폴더의 index.jsp
	}
}
