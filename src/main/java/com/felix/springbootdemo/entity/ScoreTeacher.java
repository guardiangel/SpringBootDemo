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
@Table(name = "score_teacher")
public class ScoreTeacher {
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

    @Column(name = "tea_no", length = 20)
    private String teaNo;

    @Column(name = "tea_name", length = 50)
    private String teaName;

    @Column(name = "tea_phone", length = 50)
    private String teaPhone;

    @Column(name = "tea_status")
    private Integer teaStatus;

    @Column(name = "tea_desc", length = 100)
    private String teaDesc;

    @Override
    public String toString() {
        return "ScoreTeacher{" +
                "id=" + id +
                ", createUserName='" + createUserName + '\'' +
                ", createTime=" + createTime +
                ", updateUserName='" + updateUserName + '\'' +
                ", updateTime=" + updateTime +
                ", teaNo='" + teaNo + '\'' +
                ", teaName='" + teaName + '\'' +
                ", teaPhone='" + teaPhone + '\'' +
                ", teaStatus=" + teaStatus +
                ", teaDesc='" + teaDesc + '\'' +
                '}';
    }
}