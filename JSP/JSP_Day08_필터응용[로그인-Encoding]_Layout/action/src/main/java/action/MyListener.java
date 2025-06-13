package action;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener{

	public MyListener() {
		System.out.println("listener construct!!");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("listener exec!!!");
		ServletContextListener.super.contextInitialized(sce);
	}
}
