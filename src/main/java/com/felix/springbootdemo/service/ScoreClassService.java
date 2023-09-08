package com.felix.springbootdemo.service;

import com.felix.springbootdemo.entity.ScoreClass;
import com.felix.springbootdemo.repository.ScoreClassRepository;
import jakarta.annotation.Resource;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "scoreClassService")
public class ScoreClassService {
    private final Logger log = ESAPI.getLogger(ScoreClassService.class);
    @Resource(name = "scoreClassRepository")
    private ScoreClassRepository scoreClassRepository;

    public List<ScoreClass> selectMySqlPage(String className, Pageable pageable) {

        List<ScoreClass> scoreClassList
                = scoreClassRepository.selectMySqlPage(className, pageable);

        log.info(Logger.EVENT_SUCCESS, "ScoreClassService.selectMySqlPage() execute, className="
                + className + ",pageable="
                + pageable + ",scoreClassList.size()="
                + (scoreClassList == null ? 0 : scoreClassList.size()));

        return scoreClassList;
    }
}
