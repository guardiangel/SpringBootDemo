package com.felix.springbootdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@DynamicUpdate
@Table(name = "score_class")
public class ScoreClass {
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

    @Column(name = "class_no", length = 20)
    private String classNo;

    @Column(name = "class_name", length = 50)
    private String className;

    @Column(name = "class_teacher", length = 50)
    private String classTeacher;

    @Column(name = "class_status")
    private Integer classStatus;

    @Column(name = "class_desc", length = 100)
    private String classDesc;

    @Override
    public String toString() {
        return "ScoreClass{" +
                "id=" + id +
                ", createUserName='" + createUserName + '\'' +
                ", createTime=" + createTime +
                ", updateUserName='" + updateUserName + '\'' +
                ", updateTime=" + updateTime +
                ", classNo='" + classNo + '\'' +
                ", className='" + className + '\'' +
                ", classTeacher='" + classTeacher + '\'' +
                ", classStatus=" + classStatus +
                ", classDesc='" + classDesc + '\'' +
                '}';
    }
}