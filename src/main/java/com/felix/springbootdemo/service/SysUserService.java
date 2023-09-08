package com.felix.springbootdemo.service;

import com.felix.springbootdemo.constants.ErrorCodeEnums;
import com.felix.springbootdemo.entity.SysUser;
import com.felix.springbootdemo.exceptions.CustomException;
import com.felix.springbootdemo.repository.SysUserRepository;
import com.felix.springbootdemo.utils.JSONResult;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "sysUserService")
public class SysUserService {

    private final Logger log = ESAPI.getLogger(SysUserService.class);

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;
    @Resource(name = "sysUserRepository")
    private SysUserRepository sysUserRepository;

    public List<SysUser> selectMySqlPage(Pageable pageable) {

        List<SysUser> sysUserList
                = sysUserRepository.getOnlineUserIdList( pageable);

        log.info(Logger.EVENT_SUCCESS, "SysUserService.selectMySqlPage() execute "
                + ",pageable=" + pageable
                + ",scoreClassList.size()="
                + (sysUserList == null ? 0 : sysUserList.size()));

        return sysUserList;
    }

    /**
     * get personal info
     * @param token
     * @return
     */
    public JSONResult<Map<String, String>> getUserInfo(String token) {
        if (StringUtils.hasLength(token)) {
            Object userInfo = redisTemplate.opsForValue().get(token);
            if (userInfo == null) {
                throw new CustomException(ErrorCodeEnums.ERROR_CODE_1002);
            }
            Gson gson = new Gson();
            SysUser sysUser = gson.fromJson(userInfo.toString(), SysUser.class);
            Map<String, String> map = new HashMap<>();
            map.put("name", sysUser.getUserName());
            map.put("avatar", sysUser.getAvatar());
            JSONResult<Map<String, String>> jsonResult = new JSONResult<>();
            return jsonResult.success(map);
        } else {
            throw new CustomException(ErrorCodeEnums.ERROR_CODE_1008);
        }
    }

    public List<SysUser> getUserByLoginName(String loginName) {
        return sysUserRepository.getUserByLoginName(loginName,null);
    }
}
