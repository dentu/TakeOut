package com.takeout.service.serviceImpl;

import com.takeout.entity.User;
import com.takeout.mapper.UserMapper;
import com.takeout.service.UserService;
import com.takeout.util.KaisaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public User login(String account, String password)
    {
        // 密码加密
        password = KaisaUtil.encryptKaisa(password,987);
        return userMapper.login(account,password);
    }

    @Override
    public User findEmailOrPhoneOrAccount(String account) {
        return userMapper.findEmailOrPhoneOrAccount(account);
    }

    @Override
    public void signup(User user) {
        // 密码加密
        user.setPassword(KaisaUtil.encryptKaisa(user.getPassword(),987));
        //头像
        user.setHeadImg("https://image.clearsky0.xyz/mall/images/20211221171042.jpg");
        userMapper.signup(user);
    }
}
