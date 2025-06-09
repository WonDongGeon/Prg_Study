package phonebook;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/")
public class PhonebookController extends HttpServlet {
	PhonebookService service;
	
	public PhonebookController() {
		service = new PhonebookService();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(req.getRequestURI());
		
		String page="list.jsp";
		System.out.println(req.getRequestURI());
		System.out.println(req.getRequestURI().split("/").length);
		
		if(req.getRequestURI().split("/").length ==0) {
			resp.sendRedirect("/list");
			return;
		}
		
		switch(req.getRequestURI().split("/")[1]) {
		
		case "insertform" : 
			System.out.println("입력폼 요청");
			//resp.sendRedirect("/WEB-INF/inserform.jsp");
			//req.getRequestDispatcher("/WEB-INF/insertform.jsp").forward(req, resp);
			page = "insertform.jsp";
			break;
			
		case "insert" : 
			System.out.println("입력 처리");
			MultipartRequest multi = new MultipartRequest(
					req,// 데이터스트림 객체
					"D:/work/eclipse-workspace/Phonebookv2/src/main/webapp/img", // 파일 저장 위치
					5*1024*1024, // 파일 크기 제한
					"UTF-8", // 엔코딩
					new DefaultFileRenamePolicy()
			);
			
			Enumeration<?> files = multi.getFileNames(); // 여러개의 파일인지 확인, name 속성들을 가져옴
			String filename = (String)files.nextElement();
			
			int result = service.insert(
					new Phonebook(
					0,  
					multi.getParameter("name"),
					multi.getParameter("hp"),
					multi.getParameter("email"),
					multi.getParameter("memo"),
					multi.getFilesystemName(filename)
					)
			);
			
			if(result>0) {
				req.setAttribute("state", "insert success");
			} else {
				req.setAttribute("state", "insert fail");
			}
			//req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp); 
			page = "result.jsp";
			break;
			
		case "list" : 
			System.out.println("전체 출력");
			List<Phonebook> list = service.findAll();
			req.setAttribute("list", list);
			//req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp); 
			page="list.jsp";
			break;
			
		case "view" : 
			System.out.println("선택 출력");
			req.setAttribute("pb", service.findById(Integer.parseInt(req.getParameter("id"))));
			//req.getRequestDispatcher("/WEB-INF/view.jsp").forward(req, resp); 
			page = "view.jsp";
			break;
			
		case "updateform" :
			System.out.println("수정폼 요청");
			req.setAttribute("pb", service.findById(Integer.parseInt(req.getParameter("id"))));
			//req.getRequestDispatcher("/WEB-INF/updateform.jsp").forward(req, resp); 
			page = "updateform.jsp";
			break;
			
		case "update" : 
			System.out.println("수정 처리");
			MultipartRequest multi2 = new MultipartRequest(
					req,// 데이터스트림 객체
					"D:/work/eclipse-workspace/Phonebookv2/src/main/webapp/img", // 파일 저장 위치
					5*1024*1024, // 파일 크기 제한
					"UTF-8", // 엔코딩
					new DefaultFileRenamePolicy()
			);
			
			Enumeration<?> files2 = multi2.getFileNames(); // 여러개의 파일인지 확인, name 속성들을 가져옴
			String filename2 = (String)files2.nextElement();
			
			result = service.updateById(
					new Phonebook(
							Integer.parseInt(multi2.getParameter("id")),
							multi2.getParameter("name"),
							multi2.getParameter("hp"),
							multi2.getParameter("email"),
							multi2.getParameter("memo"),
							multi2.getFilesystemName(filename2)
					)
			);
			if(result>0) {
				req.setAttribute("state", "update success");
			} else {
				req.setAttribute("state", "update fail");
			}
			//req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp); 
			page = "result.jsp";
			break;
			
		case "delete" : 
			System.out.println("삭제 처리");
			result = service.deleteById(Integer.parseInt(req.getParameter("id")));
			if(result>0) {
				req.setAttribute("state", "delete success");
			} else {
				req.setAttribute("state", "delete fail");
			}
			//req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp); 
			page = "result.jsp";
			break;
			
		default : resp.sendRedirect("/list"); break;
		}	
		req.getRequestDispatcher("/WEB-INF/"+page).forward(req, resp);
		
	}
}
