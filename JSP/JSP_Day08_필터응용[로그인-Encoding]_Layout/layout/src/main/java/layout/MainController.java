package layout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MainController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mainpage="main.jsp";
		
		switch (req.getRequestURI()) {
		case "/loginform":
			mainpage="login.jsp";
			break;
		case "/creatememberform":
			mainpage="creatememberform.jsp";
			break;

		default:
			break;
		}
		
		req.setAttribute("mainpage", mainpage);
		req.getRequestDispatcher("/WEB-INF/index.jsp")
		.forward(req, resp);
	}
}







