package kr.re.kitri.isrealboot.controller;

import kr.re.kitri.isrealboot.model.AnnouncePost;
import kr.re.kitri.isrealboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class IsrealController {

    @Autowired
    private UserService isrealService;

    @GetMapping("/announce")
    public List<AnnouncePost> heroes() {
        return isrealService.getAnnounces();
    }

}
