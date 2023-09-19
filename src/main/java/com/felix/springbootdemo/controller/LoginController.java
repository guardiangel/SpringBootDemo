package com.felix.springbootdemo.controller;

import cn.hutool.crypto.SecureUtil;
import com.felix.springbootdemo.constants.CommonConstants;
import com.felix.springbootdemo.constants.ErrorCodeEnums;
import com.felix.springbootdemo.entity.SysUser;
import com.felix.springbootdemo.exceptions.CustomException;
import com.felix.springbootdemo.service.SysUserService;
import com.felix.springbootdemo.utils.JSONResult;
import com.felix.springbootdemo.utils.LoginUtils;
import com.felix.springbootdemo.vo.reponseVo.UserVo;
import com.felix.springbootdemo.vo.requestVo.sysuser.SysUserRequestVo;
import com.felix.springbootdemo.vo.requestVo.sysuser.SysUserRequestVoGroup_Login;
import com.google.gson.Gson;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import jakarta.annotation.Resource;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.felix.springbootdemo.constants.ErrorCodeEnums.ERROR_CODE_1008;

@RestController(value = "loginController")
@RequestMapping("/login")
public class LoginController {
    private final Logger log = ESAPI.getLogger(LoginController.class);
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Resource(name = "jsonResult")
    private JSONResult jsonResult;

    @Resource(name = "typeAdapterRegistration")
    private Gson gson;

    @Resource(name = "sysUserService")
    private SysUserService sysUserService;

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

    @PostMapping("/login")
    public JSONResult login(@Validated(SysUserRequestVoGroup_Login.class)
                                @RequestBody SysUserRequestVo sysUser) {
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new CustomException(ErrorCodeEnums.ERROR_CODE_1000);
        }

        String key = CommonConstants.LOGIN_CAPTCHA_CODE_KEY + sysUser.getUuid();
        Object imageCodeRedisObj = redisTemplate.opsForValue().get(key);
        String imageCodeRedis = imageCodeRedisObj == null ? "" : imageCodeRedisObj.toString();

        if (!StringUtils.hasLength(imageCodeRedis)) {
            throw new CustomException(ErrorCodeEnums.ERROR_CODE_1011);
        }
        //compare the image code
        if (!imageCodeRedis.equals(sysUser.getImageCode())) {
            throw new CustomException(ErrorCodeEnums.ERROR_CODE_1012);
        }

        List<SysUser> existUserList = sysUserService.getUserByLoginName(sysUser.getLoginName());
        if (CollectionUtils.isEmpty(existUserList)) {
            throw new CustomException(ErrorCodeEnums.ERROR_CODE_1005);
        }
        if (existUserList.size() > 1) {
            throw new CustomException(ErrorCodeEnums.ERROR_CODE_1006);
        }

        SysUser currentUser = existUserList.get(0);
        if (!currentUser.getPassword()
                .equalsIgnoreCase(SecureUtil.md5(sysUser.getPassword()))) {
            throw new CustomException(ErrorCodeEnums.ERROR_CODE_1007);
        }

        //Save user info to Redis
        String token = LoginUtils.getLoginToken();

        redisTemplate.opsForValue().set(token, gson.toJson(currentUser, SysUser.class),
                CommonConstants.LOGIN_TIME_OUT, TimeUnit.MINUTES);

        //If forcelly kick out user, delete the user in redis
        redisTemplate.opsForValue().set(String.valueOf(currentUser.getId()),
                String.valueOf(currentUser.getId()),
                CommonConstants.LOGIN_TIME_OUT, TimeUnit.MINUTES);

        //Return token to frontend
        UserVo userVo = new UserVo();
        userVo.setToken(token);
        userVo.setAvatar(currentUser.getAvatar());
        userVo.setLoginName(currentUser.getLoginName());
        userVo.setUserName(currentUser.getUserName());
        userVo.setUserId(currentUser.getId());
        return jsonResult.success(userVo);
    }

    @GetMapping("/logout")
    public JSONResult logout(@RequestParam("token") String token) {
        if (token == null || "".equals(token.trim())) {
            throw new CustomException(ERROR_CODE_1008.getCode(), ERROR_CODE_1008.getMessage());
        }
        boolean flag = redisTemplate.delete(token);
        if (!flag) {
            log.error(Logger.EVENT_FAILURE,
                    "Can't logout successfully, the requested token=" + token);
        }
        return jsonResult.success("Delete success");
    }

}
