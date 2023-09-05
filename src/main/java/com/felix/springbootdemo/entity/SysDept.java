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
@Table(name = "sys_dept")
public class SysDept {
    @Id
    @Column(name = "dept_id", nullable = false)
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "dept_name", length = 30)
    private String deptName;

    @Column(name = "order_num")
    private Integer orderNum;

    @Column(name = "leader", length = 20)
    private String leader;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

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

    @Override
    public String toString() {
        return "SysDept{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", deptName='" + deptName + '\'' +
                ", orderNum=" + orderNum +
                ", leader='" + leader + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}