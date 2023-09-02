package com.felix.springbootdemo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sys_user_role")
public class SysUserRole {
    @EmbeddedId
    private SysUserRoleId id;

    //TODO [JPA Buddy] generate columns from DB
}