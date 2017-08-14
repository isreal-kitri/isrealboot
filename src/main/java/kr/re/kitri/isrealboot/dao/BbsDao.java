package kr.re.kitri.isrealboot.dao;

import kr.re.kitri.isrealboot.model.AnnouncePost;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BbsDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<AnnouncePost> selectAnnounces() {
        return sqlSession.selectList("mappers.announce.selectAnnounces");
    }
}
