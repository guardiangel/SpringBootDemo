package com.felix.springbootdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@DynamicUpdate
@Table(name = "sys_oper_log")
public class SysOperLog {
    @Id
    @Column(name = "oper_id", nullable = false)
    private Long id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "action", length = 100)
    private String action;

    @Column(name = "method", length = 100)
    private String method;

    @Column(name = "channel", length = 20)
    private String channel;

    @Column(name = "oper_name", length = 50)
    private String operName;

    @Column(name = "dept_name", length = 50)
    private String deptName;

    @Column(name = "oper_url")
    private String operUrl;

    @Column(name = "oper_ip", length = 30)
    private String operIp;

    @Column(name = "oper_location")
    private String operLocation;

    @Column(name = "oper_param")
    private String operParam;

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "error_msg", length = 2000)
    private String errorMsg;

    @Column(name = "oper_time")
    private LocalDateTime operTime;

    @Override
    public String toString() {
        return "SysOperLog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", action='" + action + '\'' +
                ", method='" + method + '\'' +
                ", channel='" + channel + '\'' +
                ", operName='" + operName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", operUrl='" + operUrl + '\'' +
                ", operIp='" + operIp + '\'' +
                ", operLocation='" + operLocation + '\'' +
                ", operParam='" + operParam + '\'' +
                ", status='" + status + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", operTime=" + operTime +
                '}';
    }
}