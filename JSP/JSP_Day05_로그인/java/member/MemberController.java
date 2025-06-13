package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//페이지 호출에 대한 jsp파일을 uri명령으로 변환정리
		//로그인폼열기-login.jsp-xxxx(uri명령)
		//로그인처리-login_proc.jsp-xxxx(uri명령)
		//로그아웃-logout.jsp-xxxx(uri명령)
		
	}
}
