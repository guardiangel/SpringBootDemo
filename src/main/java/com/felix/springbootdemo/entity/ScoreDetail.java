package com.felix.springbootdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "score_details")
public class ScoreDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_user_name", length = 50)
    private String createUserName;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "update_user_name", length = 50)
    private String updateUserName;

    @Column(name = "update_time")
    private Instant updateTime;

    @Column(name = "stu_id")
    private Long stuId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "score_value")
    private Integer scoreValue;

    @Override
    public String toString() {
        return "ScoreDetail{" +
                "id=" + id +
                ", createUserName='" + createUserName + '\'' +
                ", createTime=" + createTime +
                ", updateUserName='" + updateUserName + '\'' +
                ", updateTime=" + updateTime +
                ", stuId=" + stuId +
                ", subjectId=" + subjectId +
                ", scoreValue=" + scoreValue +
                '}';
    }
}