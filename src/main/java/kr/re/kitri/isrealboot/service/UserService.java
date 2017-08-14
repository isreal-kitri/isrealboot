package kr.re.kitri.isrealboot.service;

import kr.re.kitri.isrealboot.model.AnnouncePost;
import kr.re.kitri.isrealboot.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

/**
 * 권한 받아오는 method
 * 유저 등록/수정/삭제 method
 * passwordEncoder : DB에 암호가 저장되기 때문에 암호화하여 등록
 */
public interface UserService extends UserDetailsService {
    Collection<GrantedAuthority> getAuthorities(String username);

    public User readUser(String username);
    public void createUser(User user);
    public void deleteUser(String username);

    public List<AnnouncePost> getAnnounces();
}
