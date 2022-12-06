package top.sql.framework.util;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/5 23:58
 * {@code @Description:} smart-framework 转型操作工具类
 */
public class CastUtil {
    
    /**
     * 转为String类型
     */
    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }
    
    /**
     * 转为string类型（提供默认值）
     */
    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }
    
    /**
     * 转为double类型
     */
    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }
    
    /**
     * 转为double类型（提供默认值）
     */
    public static double castDouble(Object obj, int defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }
    
    /**
     * 转为long类型
     */
    public static long castLong(Object obj) {
        return CastUtil.castLong(obj, 0);
    }
    
    /**
     * 转为long类型（提供默认值）
     */
    public static long castLong(Object obj, int defaultValue) {
        long longValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }
    
    /**
     * 转为boolean值
     */
    public static boolean castBoolean(Object obj) {
        return CastUtil.castBoolean(obj, false);
    }
    
    /**
     * 转为boolean值（提供默认值）
     */
    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (obj != null) {
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }
    
    /**
     * 转为int型
     */
    public static int castInt(Object obj) {
        return CastUtil.castInt(obj, 0);
    }
    
    /**
     * 转为int型（提供默认值）
     */
    private static int castInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }
}