package kr.re.kitri.isrealboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IsrealController {

    @GetMapping("")
    public String home() {
        return "hello world";
    }
}
