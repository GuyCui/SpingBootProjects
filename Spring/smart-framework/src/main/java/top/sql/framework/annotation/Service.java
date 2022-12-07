package top.sql.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/7 20:25
 * {@code @Description:} smart-framework 服务类注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
}
