package com.felix.springbootdemo.vo.requestVo.sysuser;

import com.felix.springbootdemo.vo.requestVo.common.CommonQueryById;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysUserRequestVo {
    @NotNull(message = "The id is required.",
            groups = {CommonQueryById.class,
                    SysUserRequestVoGroup_Update.class,
                    SysUserRequestVoGroup_Delete.class})
    @Min(value = 1, message = "The id is at least 1.")
    private Long id;

    @NotBlank(message = "The username should not be null",
            groups = {SysUserRequestVoGroup_Update.class})
    private String userName;
    @NotBlank(message = "The phonenumber should not be null",
            groups = {SysUserRequestVoGroup_Update.class})
    private String phonenumber;

    @NotBlank(message = "The sex should not be null",
            groups = {SysUserRequestVoGroup_Update.class})
    @Size(min = 1, max = 1, message = "sex must be 1 character long.",
            groups = {SysUserRequestVoGroup_Update.class})
    private String sex;

    @NotBlank(message = "The loginName should not be null",
            groups = {SysUserRequestVoGroup_Login.class})
    @Size(min = 1, message = "loginName must be 1 character long.",
            groups = {SysUserRequestVoGroup_Login.class})
    private String loginName;
    @NotBlank(message = "The password should not be null",
            groups = {SysUserRequestVoGroup_Login.class})
    @Size(min = 1, message = "password must be 1 character long.",
            groups = {SysUserRequestVoGroup_Login.class})
    private String password;

    @NotBlank(message = "The uuid should not be null",
            groups = {SysUserRequestVoGroup_Login.class})
    @Size(min = 1, message = "uuid must be 1 character long.",
            groups = {SysUserRequestVoGroup_Login.class})
    private String uuid;

    @NotBlank(message = "The imageCode should not be null",
            groups = {SysUserRequestVoGroup_Login.class})
    @Size(min = 1, message = "imageCode must be 1 character long.",
            groups = {SysUserRequestVoGroup_Login.class})
    private String imageCode;


}
