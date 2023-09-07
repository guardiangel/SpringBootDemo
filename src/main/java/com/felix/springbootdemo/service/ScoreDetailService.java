package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreDetail;
import com.felix.springbootdemo.repository.ScoreDetailRepository;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreDetailService {
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
            result.add((ScoreDetail)scoreDetail[0]);
        });

        return result;
    }
}
