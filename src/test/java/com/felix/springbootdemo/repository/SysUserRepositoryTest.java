package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.SysUser;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class SysUserRepositoryTest {
    @Resource(name = "sysUserRepository")
    private SysUserRepository sysUserRepository;

    @Test
    void getOnlineUserIdList() {
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        List<SysUser> sysUserList
                = sysUserRepository.getOnlineUserIdList(pageable);
        sysUserList.forEach(sysUser -> {
            System.err.println(sysUser);
        });
    }
    @Test
    void getUserByLoginName() {
        List<SysUser> sysUserList
                = sysUserRepository.getUserByLoginName("admin",null);
        sysUserList.forEach(sysUser -> {
            System.err.println(sysUser);
        });
    }

}