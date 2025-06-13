package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/my/*")
public class MyController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getRequestURI().split("/").length<1) {
			return;
		}
		
		// localhost:8888/my/add  /my/replace  /my/remove
		String command=req.getRequestURI().split("/")[2];
		switch(command) {
		case "add": 
			System.out.println("listner add!!");
			req.setAttribute("test","test");
			break;
		case "replace":
			System.out.println("listner replace!!");
			req.setAttribute("test","replace test");
			break;
		case "remove":
			System.out.println("listner remove!!");
			req.removeAttribute("test");
			break;
		}
	}
	
}
