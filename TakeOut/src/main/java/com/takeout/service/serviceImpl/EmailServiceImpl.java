package com.takeout.service.serviceImpl;

import com.google.gson.Gson;
import com.takeout.entity.EmailToken;
import com.takeout.service.EmailService;
import com.takeout.util.ApiResponseData;
import com.takeout.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class EmailServiceImpl implements EmailService {
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    private EmailUtil emailUtil;

    @Autowired
    public void setEmailUtil(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }

    private final String CODE_HTML = "$user，你好: <br><br>" +
            "你操作的邮箱验证码为：" +
            "<span style=\"font-size:20px;color:red\">$code</span>," +
            "该验证码5分钟内有效。<br><br>" +
            "如果该验证码邮件不是由你主动请求发出,请忽略并删除它! ,请勿将验证码告诉他人!";
    ApiResponseData data = new ApiResponseData();
    Gson gson = new Gson();

    // 发送验证码
    @Override
    public ApiResponseData SendCode(String email) {
        try {
            // 生成六位数的随机验证码
            String code = (int) ((Math.random() * 9 + 1) * 100000) + "";
            EmailToken token = new EmailToken();
            token.setToken(code);
            token.setEmail(email);
            // 保存到redis中
            stringRedisTemplate.opsForValue().set(token.getEmail(), gson.toJson(token), 5, TimeUnit.MINUTES);
            // 获取并替换验证码内容
            String html = CODE_HTML.replace("$code", code).replace("$user", email);
            // 发送邮件
            emailUtil.sendHTML(email, html, "mall验证码");
            return data.setCode(200).setMessage("发送成功");
        } catch (Exception e) {
            return data.setCode(400).setMessage("发送错误");
//            throw new RuntimeException(e);
        }
    }

    // 查询验证码和邮箱
    @Override
    public ApiResponseData VerifyEmail(String email, String token) {
        try {
            // 获取redis数据并转化为VerifyToken对象
            EmailToken emailToken = gson.fromJson(
                    stringRedisTemplate.opsForValue().get(email) // 获取数据
                    , EmailToken.class
            );
            if (emailToken == null && emailToken.equals("")) {
                return data.setCode(401).setMessage("验证码错误");
            } else if (emailToken.getToken().equals(token) && emailToken.getEmail().equals(email)) {
                // 验证成功删除数据
                stringRedisTemplate.delete(email);
                return data.setCode(200).setMessage("验证成功");
            } else {
                return data.setCode(401).setMessage("验证码错误");
            }
        }catch (Exception e){
            return data.setCode(401).setMessage("验证时出错");
        }
    }
}

