package com.stt.dao;

import com.stt.model.User;

public interface IUserDao {
    User findUser(Long id);
}
