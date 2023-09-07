package com.felix.springbootdemo.service;

import com.felix.springbootdemo.ErrorCodeConstants;
import com.felix.springbootdemo.entity.SysUser;
import com.felix.springbootdemo.repository.SysUserRepository;
import com.felix.springbootdemo.utils.JSONResult;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserService {

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;
    @Resource(name = "sysUserRepository")
    private SysUserRepository sysUserRepository;

    public List<SysUser> selectMySqlPage(Pageable pageable) {

        List<SysUser> sysUserList
                = sysUserRepository.getOnlineUserIdList( pageable);

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
                throw new RuntimeException(ErrorCodeConstants.ERROR_CODE_1002.getMessage());
            }
            Gson gson = new Gson();
            SysUser sysUser = gson.fromJson(userInfo.toString(), SysUser.class);
            Map<String, String> map = new HashMap<>();
            map.put("name", sysUser.getUserName());
            map.put("avatar", sysUser.getAvatar());
            JSONResult<Map<String, String>> jsonResult = new JSONResult<>();
            return jsonResult.success(map);
        } else {
            throw new RuntimeException(ErrorCodeConstants.ERROR_CODE_1008.getMessage());
        }
    }

}
