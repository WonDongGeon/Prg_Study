package member;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter extends HttpFilter implements Filter{

@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
		throws IOException, ServletException {
	System.out.println("login filter!!");
	System.out.println();// 해당 doFilter에는 getSession()없음
	//httpSession을 얻는 방법
	HttpServletRequest request=(HttpServletRequest)req;
	HttpSession session=request.getSession();
	System.out.println
	("filter session:"+session.getAttribute("id"));
	//세션을 값을 확인하여 sesstion이 null이 아니면 doFilter를 실행
	//그렇지 않으면 필터에서 웹브라우저에 데이터 전송
	//로그인처리, 회원가입 등의 기본처리요소는 실행하도록 처리
	//3개의 코드는 같은 코드이며 사용방법이 다를뿐임
	if(request.getRequestURI().equals("/login") || 
	   request.getRequestURI().equals("/creatememberform") ||
	   request.getRequestURI().equals("/createmember") ||
	   session.getAttribute("id") != null
	) {
		super.doFilter(req, res, chain);
	}
		
	List<String> allowedUris 
	= Arrays.asList("/login", "/creatememberform", "/createmember");
	if (allowedUris.contains(request.getRequestURI()) 
			|| session.getAttribute("id") != null) {
	    super.doFilter(req, res, chain);
	}

	
	if(request.getRequestURI().equals("/login")) {
		super.doFilter(req, res, chain);
	}else if(request.getRequestURI().equals("/creatememberform")){
		super.doFilter(req, res, chain);
	}else if(request.getRequestURI().equals("/createmember")){
		super.doFilter(req, res, chain);
	}else if(session.getAttribute("id") != null) {
		super.doFilter(req, res, chain);
	}
	else {
		HttpServletResponse response=(HttpServletResponse)res;
		//response.getWriter().write("로그인처리해야함!!!");
		//response.flushBuffer();
		request.getRequestDispatcher("/WEB-INF/login.jsp")
		.forward(request, response);
		return;
	}
}

	
	/*
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("login filter!!");
		System.out.println(req.getSession());
		super.doFilter(req, res, chain);
	}
	*/
	
}
