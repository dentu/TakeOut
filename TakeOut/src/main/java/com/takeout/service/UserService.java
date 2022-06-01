package com.takeout.service;

import com.takeout.entity.User;

public interface UserService
{
    User login(String account, String password);
    User findEmailOrPhoneOrAccount(String account);
    void signup(User user);
}
