package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreDetail;
import com.felix.springbootdemo.repository.ScoreDetailRepository;
import jakarta.annotation.Resource;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreDetailService {
    private final Logger log = ESAPI.getLogger(ScoreDetailService.class);
    @Resource(name = "scoreDetailRepository")
    private ScoreDetailRepository scoreDetailRepository;

    public List<ScoreDetail> selectMySqlPage(String subjectName, String stuName,
                                             Pageable pageable) {

        List<ScoreDetail> result = new ArrayList<>();

        List<Object[]> scoreDetailList
                = scoreDetailRepository.selectMySqlPage(subjectName, stuName, pageable);

        scoreDetailList.forEach(scoreDetail -> {
            ((ScoreDetail) scoreDetail[0]).setSubjectName(scoreDetail[1].toString());
            ((ScoreDetail) scoreDetail[0]).setStuName(scoreDetail[2].toString());
            result.add((ScoreDetail) scoreDetail[0]);
        });

        log.info(Logger.EVENT_SUCCESS, "ScoreDetailService.selectMySqlPage() execute, subjectName="
                + subjectName
                + ",stuName=" + stuName
                + ",pageable=" + pageable
                + ",scoreClassList.size()="
                + (scoreDetailList == null ? 0 : scoreDetailList.size()));

        return result;
    }
}
