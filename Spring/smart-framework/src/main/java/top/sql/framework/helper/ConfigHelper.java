package top.sql.framework.helper;

import top.sql.framework.ConfigConstant;
import top.sql.framework.util.PropsUtil;

import java.util.Properties;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/5 23:19
 * {@code @Description:} smart-framework 属性文件助手类
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
}