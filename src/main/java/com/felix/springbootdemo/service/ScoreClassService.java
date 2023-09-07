package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreClass;
import com.felix.springbootdemo.repository.ScoreClassRepository;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreClassService {
    @Resource(name = "scoreClassRepository")
    private ScoreClassRepository scoreClassRepository;

    public List<ScoreClass> selectMySqlPage(String className, Pageable pageable) {

        List<ScoreClass> scoreClassList
                = scoreClassRepository.selectMySqlPage(className, pageable);

        return scoreClassList;
    }
}
