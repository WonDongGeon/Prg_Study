package wwww;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Hello extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//ctrl + space하면 쉽게 불러올 수 있음
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		System.out.println("/hello url접속");
		PrintWriter out=response.getWriter();
		
		out.print("<html>");
		out.print("<head><meta charset=\"UTF-8\"></head>");
		out.print("<body>");
		out.print("<h1>hello url에 접속하였습니다.</h1>");
	
		// /hello?insa=안녕&re=5 (insa=안녕은 파라메다, 전달되는 정보)
		
		String p1 = request.getParameter("insa");
		int p2 = Integer.parseInt(request.getParameter("re"));
		System.out.println(p1);
		for(int i = 0; i < p2; i++) out.print(p1);
		//문제점은 <br>가 단순한 문자로 표현되는 문제 발생
		//이를 해결하기 위해 html1 기본문법에 해당코드를 입력
		
		out.print("</body>");
		out.print("</html>");
	}
}
