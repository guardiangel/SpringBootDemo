package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.ScoreStudent;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class ScoreStudentRepositoryTest {

    @Resource(name = "scoreStudentRepository")
    private ScoreStudentRepository scoreStudentRepository;

    @Test
    void selectMySqlPage() {
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        List<ScoreStudent> scoreStudentList
                = scoreStudentRepository.selectMySqlPage("Yan Yan","18023222222",null,pageable);
        scoreStudentList.forEach(scoreStudent -> {
            System.err.println(scoreStudent+" ");
        });
    }
}