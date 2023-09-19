package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreTeacher;
import com.felix.springbootdemo.entity.SysUser;
import com.felix.springbootdemo.repository.ScoreTeacherRepository;
import com.felix.springbootdemo.vo.requestVo.teachers.ScoreTeacherRequestVo;
import jakarta.annotation.Resource;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "scoreTeacherService")
public class ScoreTeacherService {
    private final Logger log = ESAPI.getLogger(ScoreTeacherService.class);
    @Resource(name = "scoreTeacherRepository")
    private ScoreTeacherRepository scoreTeacherRepository;

    public List<ScoreTeacher> selectMySqlPage(ScoreTeacherRequestVo scoreTeacherRequestVo,
                                              Pageable pageable) {

        List<ScoreTeacher> scoreTeacherList
                = scoreTeacherRepository
                .selectMySqlPage(scoreTeacherRequestVo.getTeaName(),
                        scoreTeacherRequestVo.getTeaPhone(), scoreTeacherRequestVo.getTeaDesc(), pageable);

        log.info(Logger.EVENT_SUCCESS, "ScoreTeacherService.selectMySqlPage() execute, teaName="
                + scoreTeacherRequestVo.getTeaName()
                + ",teaPhone=" + scoreTeacherRequestVo.getTeaPhone()
                + ",teaDesc=" + scoreTeacherRequestVo.getTeaDesc()
                + ",pageable=" + pageable
                + ",scoreClassList.size()="
                + (scoreTeacherList == null ? 0 : scoreTeacherList.size()));

        return scoreTeacherList;
    }

    public ScoreTeacher getScoreTeacherById(Long id) {
        return scoreTeacherRepository.getScoreTeacherById(id);
    }
}
