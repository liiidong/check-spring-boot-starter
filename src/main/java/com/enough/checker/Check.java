package com.enough.checker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author LIDONG290
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RUNTIME)
public @interface Check {

    /**
     * 字段校验规则
     * <p>
     * 格式：字段名+校验规则+冒号:+错误信息描述，例如：id<10:ID必须少于10
     */
    String[] value();

    /**
     * 对方法中的哪一个参数进行校验
     */
    Class argClass();

}
