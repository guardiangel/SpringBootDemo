package com.felix.springbootdemo.constants;

public final class QueryConstants {
    private QueryConstants() {

    }
    public static final String GET_ONLINEUSERIDLIST_SQL
            = "SELECT s FROM SysUser s";
    public static final String SELECTMYSQLPAGE
            = "SELECT s FROM ScoreClass s WHERE (s.className=:className OR :className IS NULL) ORDER BY s.createTime DESC";
}
