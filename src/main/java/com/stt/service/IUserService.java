package com.stt.service;

import com.stt.model.User;

public interface IUserService {

    User findUser(long userId);

    User findByUsername(String username);
}
