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
@Table(name = "sys_post")
public class SysPost {
    @Id
    @Column(name = "post_id", nullable = false)
    private Integer id;

    @Column(name = "post_code", nullable = false, length = 64)
    private String postCode;

    @Column(name = "post_name", nullable = false, length = 50)
    private String postName;

    @Column(name = "post_sort", nullable = false)
    private Integer postSort;

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