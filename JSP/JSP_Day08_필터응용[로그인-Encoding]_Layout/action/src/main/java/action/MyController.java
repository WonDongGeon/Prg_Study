package action;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MyController extends HttpServlet{

	public MyController() {
		System.out.println("servlet construct!!");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet init param exec!!");
		//super.init(config);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("servlet init no param exec!!");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet service exec!!");
		System.out.println("servlet:"+req.getAttribute("firstfilter"));
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet get exec(select)!!");
		resp.getWriter().write("get call!!");
		resp.getWriter().flush();
		//super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet post exec(insert)!!");
		resp.getWriter().write("post call!!");
		resp.getWriter().flush();
		//super.doPost(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet put exec(update)!!");
		resp.getWriter().write("put call!!");
		resp.getWriter().flush();
		//super.doPut(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet delete exec(delete)!!");
		resp.getWriter().write("delete call!!");
		resp.getWriter().flush();
		//super.doDelete(req, resp);
	}
}
