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
public class SysRoleMenuId implements Serializable {
    private static final long serialVersionUID = -344556744011507304L;
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Column(name = "menu_id", nullable = false)
    private Integer menuId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysRoleMenuId entity = (SysRoleMenuId) o;
        return Objects.equals(this.roleId, entity.roleId) &&
                Objects.equals(this.menuId, entity.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, menuId);
    }

}