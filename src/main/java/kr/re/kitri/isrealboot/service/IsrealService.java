package kr.re.kitri.isrealboot.service;

import kr.re.kitri.isrealboot.dao.BbsDao;
import kr.re.kitri.isrealboot.model.AnnouncePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class IsrealService {
    @Autowired
    private BbsDao bbsDao;

    public List<AnnouncePost> getAnnounces() {
        return bbsDao.selectAnnounces();
    }
}
