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
@Table(name = "sys_menu")
public class SysMenu {
    @Id
    @Column(name = "menu_id", nullable = false)
    private Long id;

    @Column(name = "menu_name", nullable = false, length = 50)
    private String menuName;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "order_num")
    private Integer orderNum;

    @Column(name = "url", length = 200)
    private String url;

    @Column(name = "menu_type", length = 1)
    private String menuType;

    @Column(name = "visible", length = 1)
    private String visible;

    @Column(name = "perms", length = 100)
    private String perms;

    @Column(name = "icon", length = 100)
    private String icon;

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

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", parentId=" + parentId +
                ", orderNum=" + orderNum +
                ", url='" + url + '\'' +
                ", menuType='" + menuType + '\'' +
                ", visible='" + visible + '\'' +
                ", perms='" + perms + '\'' +
                ", icon='" + icon + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}