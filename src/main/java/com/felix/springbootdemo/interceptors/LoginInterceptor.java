package com.felix.springbootdemo.interceptors;

import com.felix.springbootdemo.constants.CommonConstants;
import com.felix.springbootdemo.constants.ErrorCodeEnums;
import com.felix.springbootdemo.entity.SysUser;
import com.felix.springbootdemo.exceptions.CustomException;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.TimeUnit;

/**
 * Login interceptor
 */
public class LoginInterceptor implements HandlerInterceptor {

    private Logger log = ESAPI.getLogger(LoginInterceptor.class);

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        //get token
        String token = request.getHeader("token");
        if (!StringUtils.hasLength(token)) {
            throw new CustomException(ErrorCodeEnums.ERROR_CODE_1002);
        }

        Object userInfoObject = redisTemplate.opsForValue().get(token);
        String userInfo = userInfoObject == null ? "" : userInfoObject.toString();
        if (StringUtils.hasLength(userInfo)) {
            //If there is a userId in the redis
            SysUser sysUser = new Gson().fromJson(userInfo, SysUser.class);
            Object userIdObject = redisTemplate.opsForValue().get(sysUser.getId());
            String userId = userIdObject == null ? "" : userInfoObject.toString();
            if (StringUtils.hasLength(userId)) {
                //Set the expired time again
                redisTemplate.opsForValue()
                        .set(token, userInfo, CommonConstants.LOGIN_TIME_OUT, TimeUnit.MINUTES);
                return true;
            } else {
                log.error(Logger.EVENT_SUCCESS, "preHandle(): The userId is null.");
                throw new CustomException(ErrorCodeEnums.ERROR_CODE_1002);
            }
        } else {
            log.error(Logger.EVENT_SUCCESS, "preHandle(): Can't get userInfo from redis.");
            throw new CustomException(ErrorCodeEnums.ERROR_CODE_1002);
        }
    }
}
