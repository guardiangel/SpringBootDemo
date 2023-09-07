package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreSubject;
import com.felix.springbootdemo.repository.ScoreSubjectRepository;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreSubjectService {
    @Resource(name = "scoreSubjectRepository")
    private ScoreSubjectRepository scoreSubjectRepository;

    public List<ScoreSubject> selectMySqlPage(String subjectName, Pageable pageable) {

        List<ScoreSubject> scoreSubjectList
                = scoreSubjectRepository.selectMySqlPage(subjectName, pageable);

        return scoreSubjectList;
    }
}
