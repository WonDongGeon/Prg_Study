package phonebook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/phonebook/*")
public class PhonebookController extends HttpServlet {
		PhonebookDAOOracle dao = new PhonebookDAOOracle();
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int id = 0;
			String name = "";
			String hp = "";
			String email = "";
			String memo = "";
			Phonebook pb = null;
			int result = 0;
			req.setCharacterEncoding("utf-8"); // post방식, 한글전송일 경우 코드 확인
			//http://localhost:8888/phonebook/insert
			//http://localhost:8888/phonebook/list
			//http://localhost:8888/phonebook/view
			//http://localhost:8888/phonebook/update
			//http://localhost:8888/phonebook/delete
			
			String command = req.getRequestURI();
			System.out.println("command:"+command);
			
			// /phonebook/list 문자를 분리한 결과
			String[] commands= command.split("/");
			System.out.println("1번째값:" + commands[0]);
			System.out.println("2번째값:" + commands[1]);
			System.out.println("3번째값:" + commands[2]);
			
			//url들어오면 해석 -> 데이터를 요청(DAO를 통해) -> 저장(setAttribute) -> 보냄(JSP로 보냄)
			switch(commands[2]) {
			
			case "insert" : 
			//url요청 -> 해석 - > 값전달확인 -> dao 저장
				name = req.getParameter("name");
				hp = req.getParameter("hp");
				email = req.getParameter("email");
				memo = req.getParameter("memo");
				System.out.println(name+hp+email+memo);
				result = dao.insert(new Phonebook(0, name, hp, email, memo));
				if(result>0) {
					req.setAttribute("state", "insert success");
				} else {
					req.setAttribute("state", "insert fail");
				}
				req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp); 
				break;
				
			case "list" : 
				List<Phonebook> list = dao.findAll();
				req.setAttribute("list", list);
				req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp); 
				break;
				
			case "view" :
				id = Integer.parseInt(req.getParameter("id"));
				pb = dao.findById(id);
				req.setAttribute("pb", pb);
				req.getRequestDispatcher("/WEB-INF/view.jsp").forward(req, resp); 
				break;
				
			case "updateform":
				id = Integer.parseInt(req.getParameter("id"));
				pb = dao.findById(id);
				req.setAttribute("pb", pb);
				req.getRequestDispatcher("/WEB-INF/updateform.jsp").forward(req, resp); 
				break;
				
			case "update" : 
				id = Integer.parseInt(req.getParameter("id"));
				name = req.getParameter("name");
				hp = req.getParameter("hp");
				email = req.getParameter("email");
				memo = req.getParameter("memo");
				System.out.println(name+hp+email+memo);
				result = dao.updateById(new Phonebook(id, name, hp, email, memo));
				if(result>0) {
					req.setAttribute("state", "update success");
				} else {
					req.setAttribute("state", "update fail");
				}
				req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp); 
				break;
			case "delete" : 
				id = Integer.parseInt(req.getParameter("id"));
				result = dao.deleteById(id);
				if(result>0) {
					req.setAttribute("state", "delete success");
				} else {
					req.setAttribute("state", "delete fail");
				}
				req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp); 
				break;
				
			default: break;
			}
			
			//*****중요*****
			//URI(View : JSP : HTML) -> Controller(Servle)t -> DAO(java) -> DB
		}
}
