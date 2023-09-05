package com.felix.springbootdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sys_job")
public class SysJob {
    @EmbeddedId
    private SysJobId id;

    @Column(name = "method_name", length = 500)
    private String methodName;

    @Column(name = "params", length = 200)
    private String params;

    @Column(name = "cron_expression")
    private String cronExpression;

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "create_by", length = 64)
    private String createBy;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "update_by", length = 64)
    private String updateBy;

    @Column(name = "update_time")
    private Instant updateTime;

    @Column(name = "remark", length = 500)
    private String remark;

    @Override
    public String toString() {
        return "SysJob{" +
                "id=" + id +
                ", methodName='" + methodName + '\'' +
                ", params='" + params + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", status='" + status + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}