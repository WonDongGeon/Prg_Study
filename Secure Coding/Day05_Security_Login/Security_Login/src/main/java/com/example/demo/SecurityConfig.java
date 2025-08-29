package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//사이트 접속시마다 접속하면 및 제한이 되어 있는 부분을 해제
// http.authorizeHttpRequests();
http.authorizeHttpRequests(
(authorizeHttpRequests)->
authorizeHttpRequests.requestMatchers(
new AntPathRequestMatcher("/**")).permitAll()
).csrf((csrf)->csrf.ignoringRequestMatchers(
new AntPathRequestMatcher("/h2-console/**")))
.headers((header)->header.addHeaderWriter(
new XFrameOptionsHeaderWriter(
XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
.formLogin((formLogin) -> formLogin
.loginPage("/login")
.defaultSuccessUrl("/")
.usernameParameter("email") //이 값이 자동으로 UserSecurityService객체로 전달
.failureUrl("/login"))
.logout((logout)->logout
.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
.logoutSuccessUrl("/login")
.invalidateHttpSession(true)
);

return http.build();
}

@Bean
PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}

}