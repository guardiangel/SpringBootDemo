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
@Table(name = "sys_user_online")
public class SysUserOnline {
    @Id
    @Column(name = "sessionId", nullable = false, length = 50)
    private String sessionId;

    @Column(name = "login_name", length = 50)
    private String loginName;

    @Column(name = "dept_name", length = 50)
    private String deptName;

    @Column(name = "ipaddr", length = 50)
    private String ipaddr;

    @Column(name = "login_location")
    private String loginLocation;

    @Column(name = "browser", length = 50)
    private String browser;

    @Column(name = "os", length = 50)
    private String os;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "start_timestsamp")
    private LocalDateTime startTimestsamp;

    @Column(name = "last_access_time")
    private LocalDateTime lastAccessTime;

    @Column(name = "expire_time")
    private Integer expireTime;

    @Override
    public String toString() {
        return "SysUserOnline{" +
                "sessionId='" + sessionId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", ipaddr='" + ipaddr + '\'' +
                ", loginLocation='" + loginLocation + '\'' +
                ", browser='" + browser + '\'' +
                ", os='" + os + '\'' +
                ", status='" + status + '\'' +
                ", startTimestsamp=" + startTimestsamp +
                ", lastAccessTime=" + lastAccessTime +
                ", expireTime=" + expireTime +
                '}';
    }
}