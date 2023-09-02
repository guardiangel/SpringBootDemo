package com.felix.springbootdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sys_job_log")
public class SysJobLog {
    @Id
    @Column(name = "job_log_id", nullable = false)
    private Integer id;

    @Column(name = "job_name", nullable = false, length = 64)
    private String jobName;

    @Column(name = "job_group", nullable = false, length = 64)
    private String jobGroup;

    @Column(name = "method_name", length = 500)
    private String methodName;

    @Column(name = "params", length = 200)
    private String params;

    @Column(name = "job_message", length = 500)
    private String jobMessage;

    @Column(name = "status", length = 1)
    private String status;

    @Lob
    @Column(name = "exception_info")
    private String exceptionInfo;

    @Column(name = "create_time")
    private Instant createTime;

}