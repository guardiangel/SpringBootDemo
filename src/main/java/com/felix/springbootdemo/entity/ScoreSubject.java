package com.felix.springbootdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "score_subject")
public class ScoreSubject {
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

    @Column(name = "subject_no", length = 50)
    private String subjectNo;

    @Column(name = "subject_name", length = 50)
    private String subjectName;

    @Column(name = "subject_status")
    private Integer subjectStatus;

    @Override
    public String toString() {
        return "ScoreSubject{" +
                "id=" + id +
                ", createUserName='" + createUserName + '\'' +
                ", createTime=" + createTime +
                ", updateUserName='" + updateUserName + '\'' +
                ", updateTime=" + updateTime +
                ", subjectNo='" + subjectNo + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", subjectStatus=" + subjectStatus +
                '}';
    }
}