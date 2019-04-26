package com.stt.service.impl;

import com.stt.dao.IUserDao;
import com.stt.model.User;
import com.stt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {


    @Resource
    private IUserDao userDao;

    @Override
    public User findUser(long userId) {
        return this.userDao.findUser(userId);
    }

    @Override
    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }
}
