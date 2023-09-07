package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.ScoreSubject;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreSubjectRepositoryTest {

    @Resource(name = "scoreSubjectRepository")
    private ScoreSubjectRepository scoreSubjectRepository;
    @Test
    void selectMySqlPage() {
        List<ScoreSubject> scoreSubjectList
                = scoreSubjectRepository.selectMySqlPage("English");

        scoreSubjectList.forEach(scoreSubject -> {
            System.err.println(scoreSubject+" ");
        });
    }
}