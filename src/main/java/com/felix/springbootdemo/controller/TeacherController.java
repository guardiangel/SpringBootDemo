package com.felix.springbootdemo.controller;

import com.felix.springbootdemo.entity.ScoreTeacher;
import com.felix.springbootdemo.entity.SysUser;
import com.felix.springbootdemo.service.ScoreTeacherService;
import com.felix.springbootdemo.service.SysUserService;
import com.felix.springbootdemo.utils.JSONResult;
import com.felix.springbootdemo.vo.requestVo.common.CommonQueryById;
import com.felix.springbootdemo.vo.requestVo.sysuser.SysUserRequestVo;
import com.felix.springbootdemo.vo.requestVo.sysuser.SysUserRequestVoGroup_Delete;
import com.felix.springbootdemo.vo.requestVo.sysuser.SysUserRequestVoGroup_Update;
import com.felix.springbootdemo.vo.requestVo.teachers.ScoreTeacherRequestVo;
import jakarta.annotation.Resource;
import org.apache.commons.beanutils.BeanUtils;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.felix.springbootdemo.constants.ErrorCodeEnums.ERROR_CODE_6666;

@RestController(value = "teacherController")
@RequestMapping("/teachers")
public class TeacherController {
    private final Logger log = ESAPI.getLogger(TeacherController.class);

    @Resource(name = "jsonResult")
    private JSONResult jsonResult;
    @Resource(name = "scoreTeacherService")
    private ScoreTeacherService scoreTeacherService;

    @PostMapping("/getAllTeachers")
    public JSONResult<List<ScoreTeacher>> getAllTeachers(
            @RequestBody ScoreTeacherRequestVo scoreTeacherRequestVo) {

        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);

        List<ScoreTeacher> scoreTeacherList
                = scoreTeacherService.selectMySqlPage(scoreTeacherRequestVo, pageable);

        log.info(Logger.EVENT_SUCCESS,
                "getAllUsers(), the size of sysUserList is:"
                        + (scoreTeacherList == null ? 0 : scoreTeacherList.size()));

        return jsonResult.success(scoreTeacherList);
    }

    @PostMapping("/getScoreTeacherById")
    public JSONResult<ScoreTeacher> getScoreTeacherById(@Validated(CommonQueryById.class)
                                                        @RequestBody ScoreTeacherRequestVo scoreTeacherRequestVo) {

        ScoreTeacher scoreTeacher
                = scoreTeacherService.getScoreTeacherById(scoreTeacherRequestVo.getId());

        log.info(Logger.EVENT_SUCCESS,
                "getOnlineUserById(), the input parameter is :"
                        + scoreTeacherRequestVo.getId());

        return jsonResult.success(scoreTeacher);
    }

}
