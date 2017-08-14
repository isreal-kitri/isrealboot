package kr.re.kitri.isrealboot.config;

import kr.re.kitri.isrealboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

//import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
//import org.springframework.session.web.http.HeaderHttpSessionStrategy;
//import org.springframework.session.web.http.HttpSessionStrategy;




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
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER) // 사용자 쿠키에 세션을 저장하지 않는다
//                .and()
            .authorizeRequests()
//                .antMatchers("/user/login").permitAll()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()     // 브라우저에서 오는 OPTION에 대한 요청 처리(오류 리턴 X)
                .antMatchers("/user").hasAuthority("USER")
                .antMatchers("/admin").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .logout();
    }

    /**
     *  AuthenticationManagerBuilder에 userService bean 주입
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

//    /**
//     *  /user/login 경로를 누구나 접근 가능하도록 설정
//     *  authenticationManagerBean 메소드는 SpringSecurity에서 사용되는 인증객체를 Bean으로 등록할 때 사용
//     */
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public HttpSessionStrategy httpSessionStrategy() {
//        return new HeaderHttpSessionStrategy();         // 쿠키의 세션을 사용하는 대신 header에 'x-auth-token' 값 사용
//    }

}
