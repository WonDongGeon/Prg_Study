package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomerAccessDeniedHandler 
implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, 
			HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// 실패에 관한 페이지로 이동
		response.sendRedirect("/login/accessError");
		
	}

}
