package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.SysUser;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SysUserRepositoryTest {
    @Resource(name = "sysUserRepository")
    private SysUserRepository sysUserRepository;

    @Test
    void getOnlineUserIdList() {
        List<SysUser> sysUserList
                = sysUserRepository.getOnlineUserIdList();
        sysUserList.forEach(sysUser -> {
            System.err.println(sysUser);
        });
    }
}