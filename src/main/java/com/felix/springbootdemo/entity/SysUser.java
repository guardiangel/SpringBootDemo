package com.felix.springbootdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sys_user")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "login_name", nullable = false, length = 30)
    private String loginName;

    @Column(name = "user_name", nullable = false, length = 30)
    private String userName;

    @Column(name = "user_type", length = 2)
    private String userType;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phonenumber", length = 11)
    private String phonenumber;

    @Column(name = "sex", length = 1)
    private String sex;

    @Column(name = "avatar", length = 100)
    private String avatar;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "salt", length = 20)
    private String salt;

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "del_flag", length = 1)
    private String delFlag;

    @Column(name = "login_ip", length = 20)
    private String loginIp;

    @Column(name = "login_date")
    private Instant loginDate;

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

    @Transient
    private String uuid;
    @Transient
    private String imageCode;

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", deptId=" + deptId +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sex='" + sex + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginDate=" + loginDate +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", uuid='" + uuid + '\'' +
                ", imageCode='" + imageCode + '\'' +
                '}';
    }
}