package com.felix.springbootdemo.constants;

public final class QueryConstants {



    private QueryConstants() {
    }


    public static final String GET_ONLINEUSERIDLIST_SQL =
            "SELECT s FROM SysUser s WHERE s.delFlag='0'";
    public static final String GET_ONLINEUSER_BY_ID_SQL =
            "SELECT s FROM SysUser s WHERE s.id=:id and s.delFlag='0'";
    public static final String SELECTMYSQLPAGE_SCORE_CLASS =
            " SELECT s FROM ScoreClass s " +
                    " WHERE (s.className=:className OR :className IS NULL) ORDER BY s.createTime DESC";
    public static final String SELECTMYSQLPAGE_SCOREDETAIL =
            " SELECT s,subject.subjectName,student.stuName FROM ScoreDetail s " +
                    " LEFT JOIN ScoreSubject subject ON (s.subjectId = subject.id) " +
                    " LEFT JOIN ScoreStudent student ON (s.stuId = student.id)" +
                    " WHERE ((subject.subjectName LIKE %:subjectName% OR :subjectName IS NULL) " +
                    " OR (student.stuName LIKE %:stuName% OR stuName IS NULL)) ORDER BY s.createTime DESC";

    public static final String SELECTMYSQLPAGE_SCORESTUDENT =
            " SELECT s FROM ScoreStudent s " +
                    " WHERE ((s.stuName LIKE %:stuName% OR :stuName IS NULL) " +
                    " AND  (s.stuPhone LIKE %:stuPhone% OR :stuPhone IS NULL) " +
                    " AND  (s.stuDesc LIKE %:stuDesc% OR :stuDesc IS NULL) )" +
                    " ORDER BY s.createTime DESC";

    public static final String SELECTMYSQLPAGE_SCORESUBJECT =
            " SELECT s FROM ScoreSubject s " +
                    " WHERE ((s.subjectName LIKE %:subjectName% OR :subjectName IS NULL)) " +
                    " ORDER BY s.createTime DESC";
    public static final String SELECTMYSQLPAGE_SCORETEACHER =
            " SELECT s FROM ScoreTeacher s " +
                    " WHERE ((s.teaName LIKE %:teaName% OR :teaName IS NULL) " +
                    " AND  (s.teaPhone LIKE %:teaPhone% OR :teaPhone IS NULL) " +
                    " AND  (s.teaDesc LIKE %:teaDesc% OR :teaDesc IS NULL) )" +
                    " ORDER BY s.createTime DESC";
    public static final String GET_USER_BY_LOGINNAME = "SELECT s FROM SysUser s " +
            " WHERE s.loginName=:loginName and s.delFlag='0'";
    public static final String GET_SCORETEACHER_BYID = "SELECT s FROM ScoreTeacher s " +
            " WHERE s.id=:id";
}
