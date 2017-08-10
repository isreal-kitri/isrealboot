package kr.re.kitri.isrealboot;

import kr.re.kitri.isrealboot.dao.IsrealDao;
import kr.re.kitri.isrealboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IsrealbootApplicationTests {

	@Autowired
	private IsrealDao isrealDao;

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

}
