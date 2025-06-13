package member;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest req, 
			HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CharchterEncodingfilter proc!!!!");
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		System.out.println("connection ip:"+req.getRemoteAddr());
		super.doFilter(req, res, chain);
	}
}
