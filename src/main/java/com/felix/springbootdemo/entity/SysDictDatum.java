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
@Table(name = "sys_dict_data")
public class SysDictDatum {
    @Id
    @Column(name = "dict_code", nullable = false)
    private Long id;

    @Column(name = "dict_sort")
    private Integer dictSort;

    @Column(name = "dict_label", length = 100)
    private String dictLabel;

    @Column(name = "dict_value", length = 100)
    private String dictValue;

    @Column(name = "dict_type", length = 100)
    private String dictType;

    @Column(name = "css_class", length = 500)
    private String cssClass;

    @Column(name = "is_default", length = 1)
    private String isDefault;

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

    @Override
    public String toString() {
        return "SysDictDatum{" +
                "id=" + id +
                ", dictSort=" + dictSort +
                ", dictLabel='" + dictLabel + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", dictType='" + dictType + '\'' +
                ", cssClass='" + cssClass + '\'' +
                ", isDefault='" + isDefault + '\'' +
                ", status='" + status + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}