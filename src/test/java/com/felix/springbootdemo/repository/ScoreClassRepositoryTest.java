package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.ScoreClass;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class ScoreClassRepositoryTest {
    @Resource(name = "scoreClassRepository")
    private ScoreClassRepository scoreClassRepository;

    @Test
    void selectMySqlPage() {
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        List<ScoreClass> scoreClassList
                = scoreClassRepository.selectMySqlPage("Grade one",pageable);//Grade one
        scoreClassList.forEach(scoreClass -> System.err.println(scoreClass));
    }
}