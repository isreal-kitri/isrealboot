//package kr.re.kitri.isrealboot.controller;
//
//import kr.re.kitri.isrealboot.model.AuthenticationRequest;
//import kr.re.kitri.isrealboot.model.AuthenticationToken;
//import kr.re.kitri.isrealboot.model.User;
//import kr.re.kitri.isrealboot.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpSession;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    // SecurityConfig에서 Bean으로 등록
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    UserService userService;
//
//    /**
//     *  @RequestBody로 Body 데이터를 객체로 받는다 (JSON 형태일 경우 객체로 자동 매핑)
//     *  token으로 Authentication에 인증
//     *  인증받은 결과를 context에 set (SecurityContext에 인증값 설정)
//     *  Contoller에서 session을 파라미터로 사용하면 session값을 받아올 수 있다.
//     *  인증 완료 -> sesson에 세팅 -> 사용자 계정, 권한, session id 로 return
//     */
//    @PostMapping("/login")
//    public AuthenticationToken login(@RequestBody AuthenticationRequest authenticationRequest, HttpSession session) {
//        String username = authenticationRequest.getUsername();
//        String password = authenticationRequest.getPassword();
//
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//        Authentication authentication = authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
//
//        User user = userService.readUser(username);
//        return new AuthenticationToken(user.getName(), user.getAuthorities(), session.getId());
//    }
//
//}
