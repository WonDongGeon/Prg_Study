package securityloginAnotation.config;

//MyWebAppInitializer.java 예시 (이전 답변에서 제공된 코드)
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.EnumSet;

//web.xml없이 설정자바파일로 처리가능
//파일의 위치는 src/main/java/프로젝트명/WebApplicationInitializer 구현 OnStartup함수실행
//onStartup함수가 처음 실행되는 함수임
public class MyWebAppInitializer implements WebApplicationInitializer {

 @Override
 public void onStartup(ServletContext servletContext) throws ServletException {
	 System.out.println("web.xml대신 설정파일 실행!!");
	 //리스너(url mapping필요없음), 필터(mapping필요), 서브릿등록(mapping필요)
	 
	// 1. Root Application Context 설정 (ContextLoaderListener)
     // 애플리케이션의 "루트" 컨텍스트를 생성하고 등록합니다.
     AnnotationConfigWebApplicationContext rootContext 
     = new AnnotationConfigWebApplicationContext();
     rootContext.register(RootConfig.class,SecurityConfig.class); // RootConfig 클래스를 등록합니다.
     servletContext.addListener(new ContextLoaderListener(rootContext));

    // 2. 필터 설정 (CharacterEncodingFilter 예시)
    FilterRegistration.Dynamic characterEncodingFilter 
    = servletContext.addFilter("characterEncodingFilter"
    		, new CharacterEncodingFilter());
    characterEncodingFilter.setInitParameter("encoding", "UTF-8");
    characterEncodingFilter.setInitParameter("forceEncoding", "true");
     
	characterEncodingFilter.addMappingForUrlPatterns(EnumSet.of(
	DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
	DispatcherType.ASYNC ), true, "/*");
	
	//시큐리티 로그인 필터를 추가하시오.
	DelegatingFilterProxy securityFilter 
	= new DelegatingFilterProxy("springSecurityFilterChain");
    securityFilter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");  // 중요!
    servletContext.addFilter("springSecurityFilterChain", securityFilter)
                  .addMappingForUrlPatterns(null, false, "/*");
 	
 
     //3. DispatcherServlet 등록     
     AnnotationConfigWebApplicationContext loginServlet 
     = new AnnotationConfigWebApplicationContext();
     loginServlet.register(LoginConfig.class); // WebConfig 클래스를 등록합니다.

     ServletRegistration.Dynamic loginDispatcher 
     = servletContext.addServlet("loginDispatcher"
    		 , new DispatcherServlet(loginServlet));
     //loginDispatcher.setLoadOnStartup(1); // 서버 시작 시 로드
     loginDispatcher.addMapping("/login/*"); // 모든 요청을 DispatcherServlet이 처리하도록 매핑합니다.

     
 }
}
