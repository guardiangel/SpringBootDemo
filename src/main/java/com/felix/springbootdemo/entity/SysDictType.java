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
@Table(name = "sys_dict_type")
public class SysDictType {
    @Id
    @Column(name = "dict_id", nullable = false)
    private Integer id;

    @Column(name = "dict_name", length = 100)
    private String dictName;

    @Column(name = "dict_type", length = 100)
    private String dictType;

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

}