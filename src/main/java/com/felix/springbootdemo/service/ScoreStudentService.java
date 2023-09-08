package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreStudent;
import com.felix.springbootdemo.repository.ScoreStudentRepository;
import jakarta.annotation.Resource;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "scoreStudentService")
public class ScoreStudentService {

    private final Logger log = ESAPI.getLogger(ScoreStudentService.class);
    @Resource(name = "scoreStudentRepository")
    private ScoreStudentRepository scoreStudentRepository;

    public List<ScoreStudent> selectMySqlPage(String stuName, String stuPhone,
                                              String stuDesc,Pageable pageable) {

        List<ScoreStudent> scoreStudentList
                = scoreStudentRepository.selectMySqlPage(stuName,stuPhone,stuDesc, pageable);

        log.info(Logger.EVENT_SUCCESS, "ScoreStudentService.selectMySqlPage() execute, stuName="
                + stuName
                + ",stuPhone=" + stuPhone
                + ",stuDesc=" + stuDesc
                + ",pageable=" + pageable
                + ",scoreClassList.size()="
                + (scoreStudentList == null ? 0 : scoreStudentList.size()));

        return scoreStudentList;
    }
}
