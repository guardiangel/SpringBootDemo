package com.felix.springbootdemo.controller;

import com.felix.springbootdemo.entity.SysUser;
import com.felix.springbootdemo.service.SysUserService;
import com.felix.springbootdemo.utils.JSONResult;
import com.felix.springbootdemo.vo.requestVo.common.CommonQueryById;
import com.felix.springbootdemo.vo.requestVo.sysuser.SysUserRequestVo;
import com.felix.springbootdemo.vo.requestVo.sysuser.SysUserRequestVoGroup_Delete;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "userController")
@RequestMapping("/users")
public class UserController {
    private Logger log = ESAPI.getLogger(UserController.class);
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Resource(name = "jsonResult")
    private JSONResult jsonResult;

    @Resource(name = "typeAdapterRegistration")
    private Gson gson;

    @Resource(name = "sysUserService")
    private SysUserService sysUserService;

    @PostMapping("/getAllUsers")
    public JSONResult getAllUsers() {

        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);

        List<SysUser> sysUserList = sysUserService.selectMySqlPage(pageable);

        log.info(Logger.EVENT_SUCCESS,
                "getAllUsers(), the size of sysUserList is:"
                        + (sysUserList == null ? 0 : sysUserList.size()));

        return jsonResult.success(sysUserList);
    }

    @PostMapping("/getOnlineUserById")
    public JSONResult getOnlineUserById(@Validated(CommonQueryById.class)
                                            @RequestBody SysUserRequestVo sysUserRequestVo) {

        SysUser sysUser = sysUserService.getOnlineUserById(sysUserRequestVo.getId());

        sysUser.setPassword("");
        sysUser.setSalt("");
        sysUser.setStatus("");
        sysUser.setDelFlag("");

        log.info(Logger.EVENT_SUCCESS,
                "getOnlineUserById(), the input parameter is :"
                        + sysUserRequestVo.getId());

        return jsonResult.success(sysUser);
    }



}
