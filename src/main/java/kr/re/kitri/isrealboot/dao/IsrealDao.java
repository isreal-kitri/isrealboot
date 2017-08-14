package kr.re.kitri.isrealboot.dao;

import kr.re.kitri.isrealboot.model.Auth;
import kr.re.kitri.isrealboot.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IsrealDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    /**
     * 사용자 이름에 맞는 User 객체를 호출하는 method
     */
    public User selectUserByUsername(String username) {
        return sqlSession.selectOne("mappers.UserMapper.readUser", username);
    }

    /**
     * 사용자 이름에 할당된 권한들을 List<String> 으로 호출하는 method
     */
    public List<String> readAuthority(String username) {
        return sqlSession.selectList("mappers.UserMapper.readAuthority", username);
    }


    public void createUser(User user) {
        sqlSession.insert("mappers.UserMapper.createUser", user);
    }

    public void createAuthority(Auth userauth) {
        sqlSession.insert("mappers.UserMapper.createAuthority", userauth);
    }

    public void deleteUser(String username) {
        sqlSession.delete("mappers.UserMapper.deleteUser", username);
    }

    public void deleteAuthority(String username) {
        sqlSession.delete("mappers.UserMapper.deleteAuthority", username);
    }

}
