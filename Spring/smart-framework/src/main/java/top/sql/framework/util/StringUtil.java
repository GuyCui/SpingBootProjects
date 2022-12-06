package top.sql.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/6 21:36
 * {@code @Description:} smart-framework 字符串工具类
 */
public final class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }
    
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}