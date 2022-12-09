package top.sql.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/6 21:36
 * {@code @Description:} smart-framework 字符串工具类
 */
public final class StringUtil {
    
    /**
     * 字符串分隔符
     */
    public static final String SEPARATOR = String.valueOf((char) 29);
    
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
    
    /**
     * 分割固定格式的字符串
     */
    public static String[] splitString(String str, String separator) {
        return StringUtils.splitByWholeSeparator(str, separator);
    }
}
