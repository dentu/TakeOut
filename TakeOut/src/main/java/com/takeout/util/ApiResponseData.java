package com.takeout.util;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 返回数据类
 */
@Data
@Accessors(chain = true)
public class ApiResponseData
{
    private Integer code = 400;
    private String message = "error";
    private Object data;
    public static ApiResponseData createError(Integer code,String message)
    {
        return new ApiResponseData().setCode(code).setMessage(message);
    }
}
