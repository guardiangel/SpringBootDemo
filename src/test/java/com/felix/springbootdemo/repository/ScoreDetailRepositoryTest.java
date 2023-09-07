package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.ScoreDetail;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ScoreDetailRepositoryTest {
    @Resource(name = "scoreDetailRepository")
    private ScoreDetailRepository scoreDetailRepository;

    @Test
    void selectMySqlPage() {
        List<Object[]> scoreDetails
                = scoreDetailRepository.selectMySqlPage("Literature", null);

        scoreDetails.forEach(scoreDetail -> {
            ((ScoreDetail) scoreDetail[0]).setSubjectName(scoreDetail[1].toString());
            ((ScoreDetail) scoreDetail[0]).setStuName(scoreDetail[2].toString());
            System.err.println(scoreDetail[0]);
        });
    }
}