package com.felix.springbootdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
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
    private Instant startTimestsamp;

    @Column(name = "last_access_time")
    private Instant lastAccessTime;

    @Column(name = "expire_time")
    private Integer expireTime;

}