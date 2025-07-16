package securityloginAnotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //loginDispatcher.setLoadOnStartup(1)
//@ComponentScan(basePackages = "securityloginAnotation.config")
public class LoginConfig {
public LoginConfig() {
	System.out.println("login servlet config!!");
}
}
