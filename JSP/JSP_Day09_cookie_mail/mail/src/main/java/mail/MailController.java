package mail;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mail/*")
public class MailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MailController() {
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getRequestURI());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;encoding=utf-8");
		switch(request.getRequestURI()) {
		case "/mail/sendemailform":
			request.getRequestDispatcher("/WEB-INF/sendemail.jsp")
			.forward(request, response);
		break;
		case "/mail/sendemail":
			MailData data=new MailData(
					request.getParameter("recvemail"),
					request.getParameter("subject"),
					request.getParameter("content")
					);
			//new MyEmail().sendMail(data);
			String msg="";
			if(MyEmail.getInstance().sendMail(data)) {
				msg="메일발송성공";
			}else {
				msg="메일발송실패";
			}
			response.getWriter()
			.write("<script>alert('"+msg+"');"
					+ "location.href='/mail/sendemailform';</script>");
			response.getWriter().flush();
			break;
		}
	}

}
