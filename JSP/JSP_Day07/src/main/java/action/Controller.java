package action;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Controller extends HttpServlet {
	
	public Controller() {
		System.out.println("servlet contstruct!!");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("filter init no param exec!!");
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("filter init param exec!!");
		//super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet service exec!!");
		super.service(req, resp);
	}
	
	//데이터베이스에서 Select 역할
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet get exec(select)!!");
		super.doGet(req, resp);
	}
	
	//데이터베이스에서 Insert 역할
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet post exec(insert)!!");
		super.doPost(req, resp);
	}
	
	//데이터베이스에서 Update 역할
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet put exec(update)!!");
		super.doPut(req, resp);
	}
	
	//데이터베이스에서 Delete 역할
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet delete exec(delete)!!");
		super.doDelete(req, resp);
	}
}
