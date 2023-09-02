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
@Table(name = "sys_notice")
public class SysNotice {
    @Id
    @Column(name = "notice_id", nullable = false)
    private Integer id;

    @Column(name = "notice_title", nullable = false, length = 50)
    private String noticeTitle;

    @Column(name = "notice_type", nullable = false, length = 2)
    private String noticeType;

    @Column(name = "notice_content", nullable = false, length = 500)
    private String noticeContent;

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

    @Column(name = "remark")
    private String remark;

}