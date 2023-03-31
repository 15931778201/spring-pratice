package cn.wusx.springboot.controller;

import cn.wusx.springboot.dao.master.UserDao;
import cn.wusx.springboot.dao.slave.HeroDao;
import cn.wusx.springboot.model.Hero;
import cn.wusx.springboot.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private HeroDao heroDao;

    /**
     *  查找所有用户
     * @return
     */
    @RequestMapping("/getAllUser")
    public List<UserEntity> getAllUser(){
        return userDao.getAll();
    }
    /**
     *  查找所有英雄
     * @return
     */
    @RequestMapping("/getAllHero")
    public List<Hero> getAllHero(){
        return heroDao.getAllHero();
    }

}
