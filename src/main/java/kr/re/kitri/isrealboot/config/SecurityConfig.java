package kr.re.kitri.isrealboot.config;

import kr.re.kitri.isrealboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *  WebSecurityConfigurerAdapter는 기본적인 웹 인증에 대한 부분 구현해놓은 클래스, 수정이 필요한 것만 override
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    /**
     *  .csrf().disable()       : Cross Site Request Forgery 처리, 일단은 disable 해둔다.
     *  .authorizeRequests()    : 요청에 대한 권한 처리, .anyRequest().authenticated() : 어떠한 요청에라도 인증 요구
     *  .and().formLogin()      : Form을 이용한 로그인 처리
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin();
    }

    /**
     *  AuthenticationManagerBuilder에 userService bean 주입
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

}
