package board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//서블릿맵핑을 web.xml에서 /board/*로 처리할 경우 해당하는 파일은
//자동으로 /board/가 붙게되는 구조이므로 full uri를 적을 필요없음
@Controller
//@RequestMapping("/board") //존재하는 /board/board/ (필요없는 url이됨)
public class BoardController {
	
	public BoardController() {
		System.out.println("Board 생성자");
	}
	
	@RequestMapping("index")
	public String index() {
		return "index"; //views/board/index.jsp
	}
}
