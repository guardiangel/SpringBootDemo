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
@Table(name = "sys_role")
public class SysRole {
    @Id
    @Column(name = "role_id", nullable = false)
    private Integer id;

    @Column(name = "role_name", nullable = false, length = 30)
    private String roleName;

    @Column(name = "role_key", nullable = false, length = 100)
    private String roleKey;

    @Column(name = "role_sort", nullable = false)
    private Integer roleSort;

    @Column(name = "status", nullable = false, length = 1)
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

}