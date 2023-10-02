package com.code.musicapi.V1_REg_and_Login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class RegController {
    @Autowired
    RegModel rm;
    @PostMapping("/new")
    public String Register(@RequestBody RegEntity re) {
        return rm.Register(re);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginEntity loginEntity) {
        return rm.login(loginEntity);
    }
}
