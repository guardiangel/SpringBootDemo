package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.constants.QueryConstants;
import com.felix.springbootdemo.entity.SysUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "sysUserRepository")
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

    @Query(value = QueryConstants.GET_ONLINEUSERIDLIST_SQL,nativeQuery = false)
    List<SysUser> getOnlineUserIdList(Pageable pageable);

}
