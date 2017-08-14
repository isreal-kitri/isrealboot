package kr.re.kitri.isrealboot;

import kr.re.kitri.isrealboot.dao.BbsDao;
import kr.re.kitri.isrealboot.model.AnnouncePost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BbsTest {

    @Autowired
    private BbsDao bbsDao;

    @Test
    public void selectAnnouncesTest() {
        List<AnnouncePost> testList = bbsDao.selectAnnounces();
        System.out.println(testList);
    }
}
