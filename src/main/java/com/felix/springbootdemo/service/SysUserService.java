package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.SysUser;
import com.felix.springbootdemo.repository.SysUserRepository;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {
    @Resource(name = "sysUserRepository")
    private SysUserRepository sysUserRepository;

    public List<SysUser> selectMySqlPage(Pageable pageable) {

        List<SysUser> sysUserList
                = sysUserRepository.getOnlineUserIdList( pageable);

        return sysUserList;
    }

}
