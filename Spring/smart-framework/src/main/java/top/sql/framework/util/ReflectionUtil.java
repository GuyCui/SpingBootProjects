package top.sql.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/7 20:50
 * {@code @Description:} smart-framework 反射工具类
 */
public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);
    
    /**
     * 创建实例
     */
    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
            // new instance failure
            LOGGER.error("创建实例失败", e);
            throw new RuntimeException(e);
        }
        return instance;
    }
    
    /**
     * 调用方法
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception e) {
            LOGGER.error("调用方法失败", e);
            throw new RuntimeException(e);
        }
        return result;
    }
    
    /**
     * 设置成员变量的值
     */
    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            LOGGER.error("设置成员变量失败", e);
            throw new RuntimeException(e);
        }
    }
}
