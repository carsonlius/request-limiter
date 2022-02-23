package com.carsonlius.annos;

import com.carsonlius.enums.LimitType;

import java.lang.annotation.*;

/**
 * 自定义限流注解
 * @version V1.0
 * @author: liusen
 * @date: 2022年02月22日 16时22分
 * @contact liusen@huice.com
 * @company 掌上先机 (http://www.huice.com)
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Limit {
    /**
     * 限流名字
     * */
    String name() default "";

    /**
     * key
     * */
    String key() default "";

    /**
     * key前缀
     * */
    String prefix() default "";

    /**
     * 单位秒 给定的时间范围
     * */
    int preiod();

    /**
     * 一定时间内最多的访问次数
     * */
    int count();

    /**
     * 限流的类型(用户自定义key 或者 请求ip)
     * */
    LimitType limitType() default LimitType.CUSTOMER;
}
