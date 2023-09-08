package com.felix.springbootdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "score_student")
public class ScoreStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_user_name", length = 50)
    private String createUserName;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_user_name", length = 50)
    private String updateUserName;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "stu_no", length = 20)
    private String stuNo;

    @Column(name = "stu_name", length = 10)
    private String stuName;

    @Column(name = "stu_phone", length = 50)
    private String stuPhone;

    @Column(name = "stu_class", length = 50)
    private String stuClass;

    @Column(name = "stu_status")
    private Integer stuStatus;

    @Column(name = "stu_desc", length = 100)
    private String stuDesc;

    @Override
    public String toString() {
        return "ScoreStudent{" +
                "id=" + id +
                ", createUserName='" + createUserName + '\'' +
                ", createTime=" + createTime +
                ", updateUserName='" + updateUserName + '\'' +
                ", updateTime=" + updateTime +
                ", stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuStatus=" + stuStatus +
                ", stuDesc='" + stuDesc + '\'' +
                '}';
    }
}