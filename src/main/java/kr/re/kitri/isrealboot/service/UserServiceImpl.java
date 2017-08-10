package kr.re.kitri.isrealboot.service;

import kr.re.kitri.isrealboot.dao.IsrealDao;
import kr.re.kitri.isrealboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IsrealDao isrealDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = isrealDao.selectUserByUsername(username);
        user.setAuthorities(getAuthorities(username));
        return user;
    }

    public Collection<GrantedAuthority> getAuthorities(String username) {
        List<String> stringAuthorities = isrealDao.readAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String authority : stringAuthorities) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;

    }
}
