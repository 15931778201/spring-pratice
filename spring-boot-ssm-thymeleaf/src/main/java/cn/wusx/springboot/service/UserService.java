package cn.wusx.springboot.service;

import cn.wusx.springboot.model.UserEntity;
import com.github.pagehelper.PageInfo;

public interface UserService {

    PageInfo<UserEntity> getUserList(int pageNum, int pageSize);
}
