package securityloginAnotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// Spring Security를 활성화하고 웹 보안 구성을 정의하겠다는 의미
//@Configuration
@EnableWebSecurity // Spring Security의 웹 보안 기능을 활성화합니다.
public class SecurityConfig {

	public SecurityConfig() {
		System.out.println("security config exec!!");
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // 암호화 없이 비밀번호를 사용
        // return new BCryptPasswordEncoder(); // 권장되는 안전한 비밀번호 인코더
    }

    // 2. UserDetailsService 빈 정의 (인메모리 사용자)
    // XML의 <security:user-service>와 동일
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails root = User.builder()
                .username("root")
                .password(passwordEncoder().encode("1234")) // passwordEncoder()를 사용하여 인코딩
                .roles("ADMIN", "USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(root, admin, user);
    }

    // 3. SecurityFilterChain 빈 정의 (핵심 변경 부분)
    // HTTP 보안 설정을 담당하며, XML의 <security:http> 부분과 동일
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize // 요청에 대한 접근 권한 설정 (Spring Security 6.x 스타일)
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().permitAll() // 나머지 요청은 모두 허용
            )
            .formLogin(form -> form // 폼 기반 로그인 설정
                .loginPage("/login") // 사용자 정의 로그인 페이지
                .defaultSuccessUrl("/user/index") // 로그인 성공 시 이동할 기본 URL
                .failureUrl("/login?error=true") // 로그인 실패 시 이동할 URL
                .usernameParameter("username") // 사용자명 파라미터 이름
                .passwordParameter("password") // 비밀번호 파라미터 이름
                .permitAll() // 로그인 페이지 및 관련 엔드포인트는 모든 사용자에게 허용
            )
            .logout(logout -> logout // 로그아웃 설정
                .logoutUrl("/logout") // 로그아웃 처리 URL (POST 요청)
                .logoutSuccessUrl("/login?logout=true") // 로그아웃 성공 시 이동할 URL
                .permitAll() // 로그아웃 엔드포인트는 모든 사용자에게 허용
            );

        return http.build(); // HttpSecurity 설정을 기반으로 SecurityFilterChain 빌드
    }
}

