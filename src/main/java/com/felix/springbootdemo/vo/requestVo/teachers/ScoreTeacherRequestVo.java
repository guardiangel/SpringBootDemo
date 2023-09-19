package com.felix.springbootdemo.vo.requestVo.teachers;

import com.felix.springbootdemo.vo.requestVo.common.CommonQueryById;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreTeacherRequestVo {
    @NotNull(message = "The id is required.",
            groups = {CommonQueryById.class})
    @Min(value = 1, message = "The id is at least 1.")
    private Long id;

    private String teaName;
    private String teaPhone;

    private String teaDesc;

}
