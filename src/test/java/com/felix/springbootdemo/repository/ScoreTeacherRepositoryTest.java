package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.ScoreTeacher;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ScoreTeacherRepositoryTest {
    @Resource(name = "scoreTeacherRepository")
    private ScoreTeacherRepository scoreTeacherRepository;
    @Test
    void selectMySqlPage() {
        List<ScoreTeacher> scoreTeacherList
                = scoreTeacherRepository.selectMySqlPage("Wu Wang", "18011120000", "Perfect teacher");
        scoreTeacherList.forEach(scoreTeacher -> System.err.println(scoreTeacher+" "));
    }
}