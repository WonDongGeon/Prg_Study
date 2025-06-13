package member;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/")
public class MemberController extends HttpServlet{
		
	MemberService service;
	
	public MemberController() {
		System.out.println("MemberController 생성!!!!!");
		//service=new MemberService();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("param init call");
				
		//전역객체를 사용할 경우 오류 발생
		//전역 파라메다를 이용하여 처리하는 방법
		super.init(config); // 중요: 반드시 호출해야 함
		//service=new MemberService(getServletContext());//사용불가 
		//System.out.println(config.getInitParameter("secpassword"));
		
		//객체파라메다를 이용하여 처리하는 방법
		//service=new MemberService(config);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("no param init call");
		//전역파라메다 객체인 Context객체를 전달
		service=new MemberService(getServletContext());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//String secpassword=getServletConfig().getInitParameter("secpassword");
		//System.out.println("***********");
		//System.out.println(secpassword);
		
		//System.out.println(getServletContext().getInitParameter("driver"));
		
		//한글이 깨지는 이유(번거로움을 제거하기 위해 필터처리)
		//req.setCharacterEncoding("utf-8");
			
	//페이지 호출에 대한 jsp파일을 uri명령으로 변환정리
	//로그인폼열기-login.jsp-xxxx(uri명령)
	//로그인처리-login_proc.jsp-xxxx(uri명령)
	//로그아웃-logout.jsp-xxxx(uri명령)
		System.out.println(req.getRequestURI());
		
		for(String s:req.getRequestURI().split("/")) {
			System.out.println(s);
		}
		
		if(req.getRequestURI().split("/").length<1) {
			return;
		}
		String command=req.getRequestURI().split("/")[1];
		switch(command) {
		case "loginform": 
			//loginform(req,resp); 
			req.getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(req, resp);
			break;
		case "login": 
			//전달되는 값 저장하기
			String id=req.getParameter("id");
			String password=req.getParameter("password");
					
			if(id == null || password == null) {
				req.getRequestDispatcher("/WEB-INF/login.jsp")
				.forward(req, resp);
				break; // or break return
			}
					
			//login(id, password,req,resp);
			//code처리
			//사이트 생성시 일부사용자만 사용할 경우 아래와 같은 코드로 작성
			/*
			if(id.equals("admin") && password.equals("1234")) {
				//로그인성공시 세션에 id저장
				req.getSession().setAttribute("id",id);
			}
			*/
			
			//여러회원을 입력하고 로그인 처리를 할 경우 db활용
			if(service.loginconfirm(id,password)) {
				//로그인성공시 세션에 id저장
				req.getSession().setAttribute("id",id);
			}else {
				req.getSession().setAttribute("id",null);
			}
			
			//페이지 이동에 의한 view설정
			req.getRequestDispatcher("/WEB-INF/result.jsp")
				.forward(req, resp);
			break;
		case "logout": 
			//logout(req,resp);
			req.getSession().invalidate();
			req.getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(req, resp);
			break;
			//회원가입폼
		case "creatememberform":
			req.getRequestDispatcher("/WEB-INF/creatememberform.jsp")
			.forward(req, resp);
			break;
		case "createmember":
			//전달받는값은 저장하기 위한 값을 객체에 저장
			Member member
			=new Member(req.getParameter("id"), 
					req.getParameter("password"), 
					req.getParameter("hp"), 
					req.getParameter("email"),
					req.getParameter("address"), 
					req.getParameter("pic"));
			//서비스에 전달
			int result=service.save(member);
			if(result>0) {
			req.setAttribute("state","member create success");
			}else {
				req.setAttribute("state","member create fail");
			}
			req.getRequestDispatcher("/WEB-INF/memberResult.jsp")
			.forward(req, resp);
			break;
		}
	}
	
	public void loginform(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("로그인폼열기");
		try {
		req.getRequestDispatcher("/WEB-INF/login.jsp")
		.forward(req, resp);
		}catch (Exception e) {}
	}
	public void login(String id, String password,
			HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("로그인처리");
		//code처리
		if(id.equals("admin") && password.equals("1234")) {
			//로그인성공시 세션에 id저장
			req.getSession().setAttribute("id",id);
		}
		//페이지 이동에 의한 view설정
		try {			
			req.getRequestDispatcher("/WEB-INF/result.jsp")
			.forward(req, resp);
			}catch (Exception e) {}
	}
	public void logout(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("로그아웃");
		req.getSession().invalidate();
		//페이지 이동에 의한 view설정
		try {			
			req.getRequestDispatcher("/WEB-INF/result.jsp")
			.forward(req, resp);
		}catch (Exception e) {}
	}
}
