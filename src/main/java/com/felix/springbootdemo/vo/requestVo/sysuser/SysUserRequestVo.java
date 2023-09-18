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
}
