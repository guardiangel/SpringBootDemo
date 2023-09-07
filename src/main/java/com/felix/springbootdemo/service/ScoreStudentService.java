package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreStudent;
import com.felix.springbootdemo.repository.ScoreStudentRepository;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreStudentService {
    @Resource(name = "scoreStudentRepository")
    private ScoreStudentRepository scoreStudentRepository;

    public List<ScoreStudent> selectMySqlPage(String stuName, String stuPhone,
                                              String stuDesc,Pageable pageable) {

        List<ScoreStudent> scoreStudentList
                = scoreStudentRepository.selectMySqlPage(stuName,stuPhone,stuDesc, pageable);

        return scoreStudentList;
    }
}
