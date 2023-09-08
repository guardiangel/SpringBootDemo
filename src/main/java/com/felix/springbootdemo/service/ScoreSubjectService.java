package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreSubject;
import com.felix.springbootdemo.repository.ScoreSubjectRepository;
import jakarta.annotation.Resource;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreSubjectService {

    private final Logger log = ESAPI.getLogger(ScoreSubjectService.class);
    @Resource(name = "scoreSubjectRepository")
    private ScoreSubjectRepository scoreSubjectRepository;

    public List<ScoreSubject> selectMySqlPage(String subjectName, Pageable pageable) {

        List<ScoreSubject> scoreSubjectList
                = scoreSubjectRepository.selectMySqlPage(subjectName, pageable);

        log.info(Logger.EVENT_SUCCESS, "ScoreSubjectService.selectMySqlPage() execute, subjectName="
                + subjectName
                + ",pageable=" + pageable
                + ",scoreClassList.size()="
                + (scoreSubjectList == null ? 0 : scoreSubjectList.size()));

        return scoreSubjectList;
    }
}
