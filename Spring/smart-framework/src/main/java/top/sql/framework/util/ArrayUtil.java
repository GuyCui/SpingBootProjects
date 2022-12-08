package top.sql.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/8 16:44
 * {@code @Description:} smart-framework 数组工具类
 */
public final class ArrayUtil {
    /**
     * 判断数组是否非空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }
    
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}
