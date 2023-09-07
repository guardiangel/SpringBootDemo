package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.ScoreSubject;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class ScoreSubjectRepositoryTest {

    @Resource(name = "scoreSubjectRepository")
    private ScoreSubjectRepository scoreSubjectRepository;
    @Test
    void selectMySqlPage() {
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        List<ScoreSubject> scoreSubjectList
                = scoreSubjectRepository.selectMySqlPage("English",pageable);

        scoreSubjectList.forEach(scoreSubject -> {
            System.err.println(scoreSubject+" ");
        });
    }
}