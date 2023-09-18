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
@Table(name = "sys_logininfor")
public class SysLogininfor {
    @Id
    @Column(name = "info_id", nullable = false)
    private Long id;

    @Column(name = "login_name", length = 50)
    private String loginName;

    @Column(name = "ipaddr", length = 50)
    private String ipaddr;

    @Column(name = "login_location")
    private String loginLocation;

    @Column(name = "browser", length = 50)
    private String browser;

    @Column(name = "os", length = 50)
    private String os;

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "msg")
    private String msg;

    @Column(name = "login_time")
    private LocalDateTime loginTime;

    @Override
    public String toString() {
        return "SysLogininfor{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", ipaddr='" + ipaddr + '\'' +
                ", loginLocation='" + loginLocation + '\'' +
                ", browser='" + browser + '\'' +
                ", os='" + os + '\'' +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}