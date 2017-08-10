package kr.re.kitri.isrealboot.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

/**
 * 권한 받아오는 method
 * 유저 등록/수정/삭제 method
 * passwordEncoder : DB에 암호가 저장되기 때문에 암호화하여 등록
 */
public interface UserService extends UserDetailsService {
    Collection<GrantedAuthority> getAuthorities(String username);
}
