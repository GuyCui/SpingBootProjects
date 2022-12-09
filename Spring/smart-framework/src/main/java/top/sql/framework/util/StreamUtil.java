package top.sql.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/9 20:08
 * {@code @Description:} smart-framework 流操作工具类
 */
public final class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);
    
    /**
     * 从输入流中获取字符串
     */
    public static String getString(InputStream is) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            if ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            LOGGER.error("获取字符串失败:", e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
