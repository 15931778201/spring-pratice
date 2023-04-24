package cn.wusx.springboot.controller;

import cn.wusx.springboot.model.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class TestController {
    @GetMapping("/hello")
    public UserEntity getHello(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("这里是TestController");
        UserEntity user=new UserEntity();
        user.setId(1L);
        user.setUserName("wusx");
        user.setUserSex("女");
        return user;
    }
}
