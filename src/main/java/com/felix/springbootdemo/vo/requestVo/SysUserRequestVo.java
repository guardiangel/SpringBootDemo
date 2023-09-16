package com.felix.springbootdemo.vo.requestVo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysUserRequestVo {
    @NotNull(message = "The id is required.")
    @Min(value = 1, message = "The id is at least 1.")
    private Long id;
}
