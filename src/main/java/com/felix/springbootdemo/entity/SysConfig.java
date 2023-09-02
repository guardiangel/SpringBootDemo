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
@Table(name = "sys_config")
public class SysConfig {
    @Id
    @Column(name = "config_id", nullable = false)
    private Integer id;

    @Column(name = "config_name", length = 100)
    private String configName;

    @Column(name = "config_key", length = 100)
    private String configKey;

    @Column(name = "config_value", length = 100)
    private String configValue;

    @Column(name = "config_type", length = 1)
    private String configType;

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