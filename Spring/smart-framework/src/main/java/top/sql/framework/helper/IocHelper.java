package top.sql.framework.helper;

import top.sql.framework.annotation.Inject;
import top.sql.framework.util.ArrayUtil;
import top.sql.framework.util.CollectionUtil;
import top.sql.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/8 16:43
 * {@code @Description:} smart-framework IOC依赖注入助手类
 */
public final class IocHelper {
    static {
        // 获取所有的Bean类与Bean实例之间的映射关系（简称Bean Map）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            // 循环遍历 Bean Map
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                // 从Bean Map中获取Bean类和Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                // 获取Bean类定义的所有成员变量（简称Bean Field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    // 循环遍历BeanField
                    for (Field beanField : beanFields) {
                        // 判断当前Bean Field是否带有Infect注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            // 在Bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                // 通过反射初始化Bean Field的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
