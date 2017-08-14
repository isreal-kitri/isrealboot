package kr.re.kitri.isrealboot;

import kr.re.kitri.isrealboot.dao.IsrealDao;
import kr.re.kitri.isrealboot.model.Auth;
import kr.re.kitri.isrealboot.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IsrealbootApplicationTests {

	@Autowired
	private IsrealDao isrealDao;

	private User user1;

	@Before
	public void setup() {
		user1 = new User();
		user1.setUsername("user1");
		user1.setPassword("pass1");
		user1.setName("USER1");
		user1.setAccountNonExpired(true);
		user1.setAccountNonLocked(true);
		user1.setCredentialsNonExpired(true);
		user1.setEnabled(true);
		user1.setAuthorities(AuthorityUtils.createAuthorityList("USER", "ADMIN"));
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void selectUserByUsernameTest() {
		User user = isrealDao.selectUserByUsername("cusonar");
		System.out.println(user);
	}

	@Test
	public void readAuthorityTest() {
		List<String> authorities = isrealDao.readAuthority("cusonar");
		System.out.println(authorities);
	}

	@Test
	public void createUserTest() {
		isrealDao.createUser(user1);

		User user = isrealDao.selectUserByUsername(user1.getUsername());
		System.out.println(user);
	}

	@Test
	public void createAuthorityTest() {
		Auth auth = new Auth();
		auth.setUsername(user1.getUsername());

		Collection<? extends GrantedAuthority> authorities1 = user1.getAuthorities();
		Iterator<? extends GrantedAuthority> it = authorities1.iterator();
		while (it.hasNext()) {
			auth.setAuthname(it.next().toString());
			isrealDao.createAuthority(auth);
		}
	}

	@Test
	public void deleteUserTest() {
		isrealDao.deleteUser(user1.getUsername());
	}
}
