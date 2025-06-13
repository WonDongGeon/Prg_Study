package action;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class My2Filter extends HttpFilter{

	public My2Filter() {
		System.out.println("filter2 construct!!");
	}
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter2 exec!!!");
		//이함수의 역할은 다음 필터로 연결시켜주는 역할
		req.setAttribute("firstfilter", "firstfilter save");
		super.doFilter(req, res, chain); 
		//req.getServletContext();
		//req.getSession();
		//req.getCookies();;
	}
}
