package com.felix.springbootdemo.controller;

import com.felix.springbootdemo.constants.CommonConstants;
import com.felix.springbootdemo.utils.JSONResult;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import jakarta.annotation.Resource;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController(value = "loginController")
@RequestMapping("/login")
public class LoginController {
    private Logger log = ESAPI.getLogger(LoginController.class);
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Resource(name = "jsonResult")
    private JSONResult jsonResult;

    @GetMapping("/getLoginImgCode/{uuid}")
    public JSONResult<String> getLoginImgCode(@PathVariable("uuid") String uuid) {
        log.info(Logger.EVENT_SUCCESS, "getLoginImgCode(): uuid=" + uuid);

        String key = CommonConstants.LOGIN_CAPTCHA_CODE_KEY + uuid;

        SpecCaptcha captcha = new SpecCaptcha(150, 50, 4);
        //Set verify code type
        captcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        String code = captcha.text().toLowerCase();
        //Put it into redis for later verification
        redisTemplate.opsForValue().set(key, code,
                CommonConstants.LOGIN_CAPTCHA_EXPIRATION, TimeUnit.MINUTES);

        return jsonResult.success(captcha.toBase64());
    }

    @GetMapping("/logout")
    public JSONResult logout(@RequestParam("token") String token) {
        boolean flag = redisTemplate.delete(token);
        if (!flag) {
            log.error(Logger.EVENT_FAILURE,
                    "Can't logout successfully, the requested token=" + token);
        }
        return jsonResult;
    }

}
