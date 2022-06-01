package com.takeout.controller;

import com.takeout.entity.User;
import com.takeout.service.UserService;
import com.takeout.util.ApiResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-05-27 15:14:06
 */
@RestController
public class UserController
{
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    // 用于返回数据
    ApiResponseData data = new ApiResponseData();
    /**
     * account: 6<account<10
     * password: 6<password<15
     */

    /**
     * 登陆
     * @param account
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ApiResponseData Login(@RequestParam("account") String account,@RequestParam("password") String password)
    {
        if (account.equals("") || account.equals(""))
        {
            return ApiResponseData.createError(400,"帐号或密码不能为空");
        }else if (account.length()< 6 || account.length() > 10 || password.length() <= 6 || password.length() >=15)
        {
            return ApiResponseData.createError(400,"帐号或密码长度错误");
        }
        try{
            User user = userService.login(account,password);
            if (user == null)
            {
                return ApiResponseData.createError(400,"帐号或密码错误");
            }
            return data.setCode(200).setMessage("success").setData(user);
        }catch (Exception e){
            return ApiResponseData.createError(400,"登陆出错");
        }

    }
    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/signup")
    public ApiResponseData signup(@RequestBody User user)
    {
        if (user.getAccount().equals("") || user.getAccount().equals("") || user.getEmail().equals(""))
        {
            return ApiResponseData.createError(400,"帐号或密码不能为空");
        }else if (user.getAccount().length()< 6 || user.getAccount().length() > 10 || user.getPassword().length() <= 6 || user.getPassword().length() >=15)
        {
            return ApiResponseData.createError(400,"帐号或密码长度错误");
        }
        // 判断邮箱格式
        if (!user.getEmail().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$"))
        {
            return ApiResponseData.createError(400,"邮箱格式错误");
        }
        // 判断帐号是否被注册
        if (userService.findEmailOrPhoneOrAccount(user.getAccount()) != null)
        {
            return ApiResponseData.createError(400,"帐号已被注册");
        }else if (userService.findEmailOrPhoneOrAccount(user.getEmail()) != null)
        {
            return ApiResponseData.createError(400,"邮箱已被注册");
        }
        return data.setCode(200).setMessage("success");
    }

}

