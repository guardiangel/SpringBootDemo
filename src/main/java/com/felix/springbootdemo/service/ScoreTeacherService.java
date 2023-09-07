package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreTeacher;
import com.felix.springbootdemo.repository.ScoreTeacherRepository;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreTeacherService {
    @Resource(name = "scoreTeacherRepository")
    private ScoreTeacherRepository scoreTeacherRepository;

    public List<ScoreTeacher> selectMySqlPage(String teaName,String teaPhone,
                                              String teaDesc,Pageable pageable) {

        List<ScoreTeacher> scoreTeacherList
                = scoreTeacherRepository.selectMySqlPage(teaName,teaPhone,teaDesc, pageable);

        return scoreTeacherList;
    }
}
