package top.sql.framework;

import top.sql.framework.helper.BeanHelper;
import top.sql.framework.helper.ClassHelper;
import top.sql.framework.helper.ControllerHelper;
import top.sql.framework.helper.IocHelper;
import top.sql.framework.util.ClassUtil;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/8 21:20
 * {@code @Description:} smart-framework 加载相应的Helper类
 */
public final class HelperLoader {
    /**
     * 初始化
     */
    public static void init() {
        Class<?>[] classList = {ClassHelper.class, BeanHelper.class, IocHelper.class, ControllerHelper.class};
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), false);
        }
    }
}
