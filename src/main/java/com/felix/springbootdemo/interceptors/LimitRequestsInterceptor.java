package com.felix.springbootdemo.interceptors;

import com.felix.springbootdemo.annotations.LimitRequestsAnnatation;
import com.felix.springbootdemo.exceptions.CustomException;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.TimeUnit;

/**
 * Limit the concurrency from the same ip
 */
public class LimitRequestsInterceptor implements HandlerInterceptor {
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Integer> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //If the request is forwarded to a method directly
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            LimitRequestsAnnatation limitRequestsAnnatation
                    = handlerMethod.getMethodAnnotation(LimitRequestsAnnatation.class);
            //If there is no annotation on one mehtod
            if (limitRequestsAnnatation == null) {
                return true;
            } else {
                //If there is a annotation
                // Get request ip
                String ip = getIpAddress(request);
                //Get request url
                String url = request.getRequestURI();
                //The key saved to redis
                String key = limitRequestsAnnatation.key() + ip + ":" + url;
                if (redisTemplate.hasKey(key)) {
                    //Every request will add 1 for the same ip
                    redisTemplate.opsForValue().increment(key, 1);
                    //If the request count is over the limit
                    if (redisTemplate.opsForValue().get(key) > limitRequestsAnnatation.count()) {
                        throw new CustomException(limitRequestsAnnatation.code(),
                                limitRequestsAnnatation.message());
                    }
                } else {
                    //Set the expiration time for the first time
                    redisTemplate.opsForValue().set(key, 1, limitRequestsAnnatation.cycle(), TimeUnit.SECONDS);
                }
                return true;
            }
        }
        return true;
    }

    /**
     * get request ip
     *
     * @param request
     * @return
     */
    private String getIpAddress(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
            }
            //For mutiple proxies, the first one is the original IP, IPs are split by ","
            if (ipAddress != null && ipAddress.length() > 15) {
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        return ipAddress;
    }
}
