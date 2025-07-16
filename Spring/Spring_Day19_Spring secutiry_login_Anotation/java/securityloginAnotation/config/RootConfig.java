package securityloginAnotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@Configuration //리스너로 등록하면 해당어노테이션이 필요없음
//@EnableWebMvc
@ComponentScan(basePackages = "securityloginAnotation.config")
public class RootConfig {

	public RootConfig() {
		System.out.println("root config exec!!");
	}
}
