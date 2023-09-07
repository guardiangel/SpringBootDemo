package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.constants.QueryConstants;
import com.felix.springbootdemo.entity.ScoreClass;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "scoreClassRepository")
public interface ScoreClassRepository extends JpaRepository<ScoreClass, Long> {
    @Query(value = QueryConstants.SELECTMYSQLPAGE_SCORE_CLASS,nativeQuery = false)
    List<ScoreClass> selectMySqlPage(@Param("className")String className, Pageable pageable);
}