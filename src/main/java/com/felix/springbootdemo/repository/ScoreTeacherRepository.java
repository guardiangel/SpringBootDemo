package com.felix.springbootdemo.repository;

import com.felix.springbootdemo.constants.QueryConstants;
import com.felix.springbootdemo.entity.ScoreSubject;
import com.felix.springbootdemo.entity.ScoreTeacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "scoreTeacherRepository")
public interface ScoreTeacherRepository extends CrudRepository<ScoreTeacher, Long> {
    @Query(value = QueryConstants.SELECTMYSQLPAGE_SCORETEACHER,nativeQuery = false)
    List<ScoreTeacher> selectMySqlPage(@Param("teaName") String teaName,
                                       @Param("teaPhone") String teaPhone,
                                       @Param("teaDesc") String teaDesc);
}