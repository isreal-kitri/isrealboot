//package kr.re.kitri.isrealboot.filter;
//
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// *  Cross Domain 이슈를 위한 필터 생성
// *  허용되는 Origin(도메인), 메소드 방식, Header를 정의해서 리턴
// *  모든 도메인에 모든 요청 받을 수 있게 된다.
// *  rest login : 리턴받은 token 값을 클라이언트에서는 http header에 x-auth-token에 assign한 뒤 요청하면 권한에 맞는 URL 호출 가능
// */
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class SimpleCorsFilter implements Filter {
//
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) res;
//
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-auth-token, content-type");
//
//        chain.doFilter(req, res);
//    }
//
//    public void init(FilterConfig filterConfig) {}
//
//    public void destroy() {}
//}
