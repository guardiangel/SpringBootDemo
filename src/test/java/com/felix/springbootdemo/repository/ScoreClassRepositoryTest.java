package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.ScoreClass;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreClassRepositoryTest {

    @Resource(name = "scoreClassRepository")
    private ScoreClassRepository scoreClassRepository;
    @Test
    void selectMySqlPage() {
        List<ScoreClass> scoreClassList
                = scoreClassRepository.selectMySqlPage("Grade one");//Grade one
        scoreClassList.forEach(scoreClass -> System.err.println(scoreClass));
    }
}