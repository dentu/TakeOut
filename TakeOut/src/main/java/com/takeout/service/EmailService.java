package com.takeout.service;

import com.takeout.util.ApiResponseData;

public interface EmailService
{
    // 发送验证码
    ApiResponseData SendCode(String email);
    ApiResponseData VerifyEmail(String email, String token);
}
