package cn.wusx.springboot.service.impl;

import cn.wusx.springboot.dao.UserDao;
import cn.wusx.springboot.model.UserEntity;
import cn.wusx.springboot.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<UserEntity> getUserList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> list=userDao.getAll();
        PageInfo<UserEntity> pageData= new PageInfo<UserEntity>(list);
        System.out.println("当前页："+pageData.getPageNum());
        System.out.println("页面大小："+pageData.getPageSize());
        System.out.println("总数："+pageData.getTotal());
        System.out.println("总页数："+pageData.getPages());
        return pageData;
    }
}

