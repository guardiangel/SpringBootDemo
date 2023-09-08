package com.felix.springbootdemo.annotations;

import java.lang.annotation.*;

/**
 * Limit the request times in a specific time period
 * One time in every five seconds
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LimitRequestsAnnatation {

    /*
    key
     */
    String key() default "limit:";

    /**
     * the cycle, default unit is second
     *
     * @return
     */
    int cycle() default 5;

    /*
    request times
     */
    int count() default 1;

    /**
     * default prompt message
     * @return
     */
    String message() default "Please don't click repeatedly";

    String code() default  "8888";
}
