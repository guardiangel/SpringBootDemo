package com.felix.springbootdemo.vo;

import lombok.Data;

@Data
public class UserVo {
    private String token;
    private String userName;
    private String loginName;
    private String avatar;
    private Long userId;
}
