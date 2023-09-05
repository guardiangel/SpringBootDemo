package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.constants.QueryConstants;
import com.felix.springbootdemo.entity.ScoreClass;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "scoreClassRepository")
public interface ScoreClassRepository extends CrudRepository<ScoreClass, Long> {
    @Query(value = QueryConstants.SELECTMYSQLPAGE,nativeQuery = false)
    List<ScoreClass> selectMySqlPage(@Param("className")String className);
}