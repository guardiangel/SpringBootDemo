package com.felix.springbootdemo.controller;

import com.felix.springbootdemo.entity.SysUser;
import com.felix.springbootdemo.service.SysUserService;
import com.felix.springbootdemo.utils.JSONResult;
import com.felix.springbootdemo.vo.requestVo.common.CommonQueryById;
import com.felix.springbootdemo.vo.requestVo.sysuser.SysUserRequestVo;
import com.felix.springbootdemo.vo.requestVo.sysuser.SysUserRequestVoGroup_Delete;
import com.felix.springbootdemo.vo.requestVo.sysuser.SysUserRequestVoGroup_Update;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.apache.commons.beanutils.BeanUtils;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
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

        if (sysUser != null) {
            sysUser.setPassword("");
            sysUser.setSalt("");
            sysUser.setStatus("");
            sysUser.setDelFlag("");
        }
        log.info(Logger.EVENT_SUCCESS,
                "getOnlineUserById(), the input parameter is :"
                        + sysUserRequestVo.getId());

        return jsonResult.success(sysUser);
    }

    /**
     * update userName, phonenumber, and sex.
     *
     * @param sysUserRequestVo
     * @return
     */
    @PostMapping("/updateSysUserInfo")
    public JSONResult updateSysUserInfo(@Validated(SysUserRequestVoGroup_Update.class)
                                        @RequestBody SysUserRequestVo sysUserRequestVo) {

        SysUser sysUser = sysUserService.getOnlineUserById(sysUserRequestVo.getId());
        try {
            BeanUtils.copyProperties(sysUser, sysUserRequestVo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(Logger.EVENT_SUCCESS,
                    "updateSysUserInfo(), error happens when copying attributes, the error is :"
                            + e);
        }

        SysUser result = sysUserService.updateSysUserInfo(sysUser);

        log.info(Logger.EVENT_SUCCESS,
                "updateSysUserInfo(), the input parameter is :"
                        + sysUserRequestVo);

        return jsonResult.success(result);
    }

    /**
     * Delete user by user id logically.
     * Update delFlag='1'
     * @param sysUserRequestVo
     * @return
     */
    @PostMapping("/deleteSysUserById")
    public JSONResult deleteSysUserById(@Validated(SysUserRequestVoGroup_Delete.class)
                                        @RequestBody SysUserRequestVo sysUserRequestVo) {

        SysUser sysUser = sysUserService.getOnlineUserById(sysUserRequestVo.getId());

        sysUser.setDelFlag("1");//1 means delete logically.

        SysUser result = sysUserService.updateSysUserInfo(sysUser);

        log.info(Logger.EVENT_SUCCESS,
                "deleteSysUserById(), the input parameter is :"
                        + sysUserRequestVo);

        return jsonResult.success(result);
    }


}
