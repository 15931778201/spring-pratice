package cn.wusx.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String getHello() {
        System.out.println("这里是Hello");
        return "hello world";
    }

    @GetMapping("/exception")
    public String hello() {
        int x = 1 / 0;
        return "hello";
    }
    @GetMapping("/exception1")
    public String test() {
        String[] ss = new String[] { "1", "2" };
        System.out.print(ss[2]);
        return "hello";
    }

    @RequestMapping("/test1")
    public String getTest1() {
        System.out.println("这里是Test1");
        return "test1 content";
    }

    @RequestMapping("/test2")
    public String getTest2() {
        System.out.println("这里是Test2");
        return "test2 content";
    }
}
