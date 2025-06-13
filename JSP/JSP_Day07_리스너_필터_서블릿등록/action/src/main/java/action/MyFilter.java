package action;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class MyFilter extends HttpFilter{

	public MyFilter() {
		System.out.println("filter construct!!");
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("filter init param exec!!!");
		//super.init(config);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("filter init no param exec!!!");
		super.init();
	}
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter exec!!!");
		super.doFilter(req, res, chain);
	}
}
