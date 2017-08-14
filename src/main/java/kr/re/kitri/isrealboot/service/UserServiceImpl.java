package kr.re.kitri.isrealboot.service;

import kr.re.kitri.isrealboot.dao.BbsDao;
import kr.re.kitri.isrealboot.dao.IsrealDao;
import kr.re.kitri.isrealboot.model.AnnouncePost;
import kr.re.kitri.isrealboot.model.Auth;
import kr.re.kitri.isrealboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IsrealDao isrealDao;
    @Autowired
    private BbsDao bbsDao;

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

    @Override public User readUser(String username) {
        User user = isrealDao.selectUserByUsername(username);

        List<String> stringAuthorities = isrealDao.readAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String authority : stringAuthorities) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }

        user.setAuthorities(authorities);
        return user;
    }

    @Override
    public void createUser(User user) {
        isrealDao.createUser(user);

        Auth auth = new Auth();
        auth.setUsername(user.getUsername());

        Collection<? extends GrantedAuthority> authorities1 = user.getAuthorities();
        Iterator<? extends GrantedAuthority> it = authorities1.iterator();
        while (it.hasNext()) {
            auth.setAuthname(it.next().toString());
            isrealDao.createAuthority(auth);
        }

    }

    @Override public void deleteUser(String username) {
        isrealDao.deleteUser(username);
        isrealDao.deleteAuthority(username);
    }

    public List<AnnouncePost> getAnnounces() {
        return bbsDao.selectAnnounces();
    }

}
