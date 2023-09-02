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
public class SysUserPostId implements Serializable {
    private static final long serialVersionUID = -3264458662666999230L;
    @Column(name = "user_id", nullable = false, length = 64)
    private String userId;

    @Column(name = "post_id", nullable = false, length = 64)
    private String postId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysUserPostId entity = (SysUserPostId) o;
        return Objects.equals(this.postId, entity.postId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, userId);
    }

}