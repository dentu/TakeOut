package com.takeout.util;

import java.util.UUID;

/**
 * 生成uuid
 */
public class UUIDUtil
{
    // 生成uuid
    public static String createUUID()
    {
        return UUID.randomUUID().toString().replace("-","");
    }

    public String uuid(){
        return createUUID();
    }
}
