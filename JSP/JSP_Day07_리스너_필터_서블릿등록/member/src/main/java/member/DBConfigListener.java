package member;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBConfigListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context=sce.getServletContext();
		//web.xml에 설정된 전역파라메다를 가져오기
		String driver=context.getInitParameter("driver");
		String url=context.getInitParameter("url");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		//System.out.println(driver);
		//System.out.println(url);
		//System.out.println(user);
		//System.out.println(password);
		//new DBConfig(driver, url, user, password);
		//new DBConfig(sce.getServletContext());
		new MemberDAO(sce.getServletContext());
		
	}
}
