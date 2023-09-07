package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.constants.QueryConstants;
import com.felix.springbootdemo.entity.ScoreSubject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "scoreSubjectRepository")
public interface ScoreSubjectRepository extends JpaRepository<ScoreSubject, Long> {
    @Query(value = QueryConstants.SELECTMYSQLPAGE_SCORESUBJECT,nativeQuery = false)
    List<ScoreSubject> selectMySqlPage(@Param("subjectName") String subjectName, Pageable pageable);
}