package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreTeacher;
import com.felix.springbootdemo.repository.ScoreTeacherRepository;
import jakarta.annotation.Resource;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreTeacherService {

    private final Logger log = ESAPI.getLogger(ScoreTeacherService.class);
    @Resource(name = "scoreTeacherRepository")
    private ScoreTeacherRepository scoreTeacherRepository;

    public List<ScoreTeacher> selectMySqlPage(String teaName, String teaPhone,
                                              String teaDesc, Pageable pageable) {

        List<ScoreTeacher> scoreTeacherList
                = scoreTeacherRepository.selectMySqlPage(teaName, teaPhone, teaDesc, pageable);

        log.info(Logger.EVENT_SUCCESS, "ScoreTeacherService.selectMySqlPage() execute, teaName="
                + teaName
                + ",teaPhone=" + teaPhone
                + ",teaDesc=" + teaDesc
                + ",pageable=" + pageable
                + ",scoreClassList.size()="
                + (scoreTeacherList == null ? 0 : scoreTeacherList.size()));

        return scoreTeacherList;
    }
}
