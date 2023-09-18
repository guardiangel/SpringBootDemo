package com.felix.springbootdemo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Entity
@DynamicUpdate
@Table(name = "sys_role_menu")
public class SysRoleMenu {
    @EmbeddedId
    private SysRoleMenuId id;

    //TODO [JPA Buddy] generate columns from DB
}