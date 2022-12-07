package top.sql.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/7 20:23
 * {@code @Description:} smart-framework 方法注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    
    /**
     * 请求类型与路径
     */
    String value();
}
