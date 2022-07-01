package com.takeout.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * 邮箱
 */
@Data
public class EmailToken
{
    @Id
    private String email;
    private String token;
}
