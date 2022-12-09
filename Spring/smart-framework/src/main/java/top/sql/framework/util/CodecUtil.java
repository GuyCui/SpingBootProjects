package top.sql.framework.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/9 20:17
 * {@code @Description:} smart-framework 编码与解码操作工具类
 */
public final class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);
    
    /**
     * 将 URL 编码
     */
    public static String encodeURL(String source) {
        String target;
        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("URL编码失败", e);
            throw new RuntimeException(e);
        }
        return target;
    }
    
    /**
     * 将 URL 解码
     */
    public static String decodeURL(String source) {
        String target;
        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (Exception e) {
            LOGGER.error("decode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }
    
    /**
     * MD5 加密
     */
    public static String md5(String source) {
        return DigestUtils.md5Hex(source);
    }
    
}
