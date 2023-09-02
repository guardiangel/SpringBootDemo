package com.felix.springbootdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SysJobId implements Serializable {
    private static final long serialVersionUID = 3197462772682967854L;
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(name = "job_name", nullable = false, length = 64)
    private String jobName;

    @Column(name = "job_group", nullable = false, length = 64)
    private String jobGroup;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysJobId entity = (SysJobId) o;
        return Objects.equals(this.jobName, entity.jobName) &&
                Objects.equals(this.jobId, entity.jobId) &&
                Objects.equals(this.jobGroup, entity.jobGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobName, jobId, jobGroup);
    }

}