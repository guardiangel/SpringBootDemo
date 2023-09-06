package com.felix.springbootdemo.constants;

public final class QueryConstants {
    private QueryConstants() {

    }
    public static final String GET_ONLINEUSERIDLIST_SQL
            = "SELECT s FROM SysUser s";
    public static final String SELECTMYSQLPAGE_SCORE_CLASS
            = "SELECT s FROM ScoreClass s WHERE (s.className=:className OR :className IS NULL) ORDER BY s.createTime DESC";
    public static final String SELECTMYSQLPAGE_SCOREDETAIL
            = "SELECT s,subject.subjectName,student.stuName FROM ScoreDetail s LEFT JOIN ScoreSubject subject ON (s.subjectId = subject.id) " +
            " LEFT JOIN ScoreStudent student ON (s.stuId = student.id)" +
            " WHERE ((subject.subjectName LIKE %:subjectName% OR :subjectName IS NULL) " +
            " OR (student.stuName LIKE %:stuName% OR stuName IS NULL)) ORDER BY s.createTime DESC";
}
