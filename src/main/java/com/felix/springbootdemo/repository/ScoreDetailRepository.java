package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.constants.QueryConstants;
import com.felix.springbootdemo.entity.ScoreDetail;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "scoreDetailRepository")
public interface ScoreDetailRepository extends JpaRepository<ScoreDetail, Long> {
    @Query(value = QueryConstants.SELECTMYSQLPAGE_SCOREDETAIL,nativeQuery = false)
    List<Object[]> selectMySqlPage(@Param("subjectName")String subjectName
    , @Param("stuName") String stuName, Pageable pageable);
}