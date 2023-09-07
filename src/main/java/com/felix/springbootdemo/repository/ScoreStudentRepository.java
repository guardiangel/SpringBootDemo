package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.constants.QueryConstants;
import com.felix.springbootdemo.entity.ScoreStudent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "scoreStudentRepository")
public interface ScoreStudentRepository extends JpaRepository<ScoreStudent, Long> {

    @Query(value = QueryConstants.SELECTMYSQLPAGE_SCORESTUDENT,nativeQuery = false)
     List<ScoreStudent> selectMySqlPage(@Param("stuName") String stuName,
                                              @Param("stuPhone") String stuPhone,
                                              @Param("stuDesc") String stuDesc, Pageable pageable);
}