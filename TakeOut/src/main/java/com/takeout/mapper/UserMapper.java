package com.takeout.mapper;

import com.takeout.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用户mapper
 */
@Mapper
public interface UserMapper
{
    /**
     * 登陆
     * @param account or email
     * @param password
     * @return
     */
    @Select("select * from user where " +
            "account = #{account} and password = #{password} " +
            "or email = #{account} and password = #{password}")
    User login(@Param("account") String account, @Param("password") String password);

    /**
     * 查找邮箱Or手机Or帐号
     * @param account
     * @return
     */
    @Select("select * from user where email = #{account} or phone = #{account} or account = #{account}")
    User findEmailOrPhoneOrAccount(@Param("account") String account);

    /**
     * 注册
     * @param user
     */
    void signup(User user);
}
