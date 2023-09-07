package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.entity.ScoreTeacher;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class ScoreTeacherRepositoryTest {
    @Resource(name = "scoreTeacherRepository")
    private ScoreTeacherRepository scoreTeacherRepository;
    @Test
    void selectMySqlPage() {
        Pageable pageable = PageRequest.of(1, 2);
        List<ScoreTeacher> scoreTeacherList
                = scoreTeacherRepository.selectMySqlPage(null,null,null, pageable);
        scoreTeacherList.forEach(scoreTeacher -> System.err.println(scoreTeacher+" "));
    }
}