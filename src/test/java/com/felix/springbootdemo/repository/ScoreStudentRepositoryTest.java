package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.ScoreStudent;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreStudentRepositoryTest {

    @Resource(name = "scoreStudentRepository")
    private ScoreStudentRepository scoreStudentRepository;

    @Test
    void selectMySqlPage() {
        List<ScoreStudent> scoreStudentList
                = scoreStudentRepository.selectMySqlPage("Yan Yan","18023222222",null);
        scoreStudentList.forEach(scoreStudent -> {
            System.err.println(scoreStudent+" ");
        });
    }
}