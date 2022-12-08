package top.sql.framework.helper;

import top.sql.framework.annotation.Action;
import top.sql.framework.bean.Handler;
import top.sql.framework.bean.Request;
import top.sql.framework.util.ArrayUtil;
import top.sql.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/8 20:55
 * {@code @Description:} smart-framework 控制器助手类
 */
public final class ControllerHelper {
    /**
     * 用于存放请求与处理器的映射关系（简称Action Map）
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();
    
    static {
        // 获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            // 循环遍历Controller类
            for (Class<?> controllerClass : controllerClassSet) {
                // 获取Controller类中定义的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    // 循环遍历这些方法
                    for (Method method : methods) {
                        // 判断当前方法中是否有带有Action注解的
                        if (method.isAnnotationPresent(Action.class)) {
                            // 在Action注解中获取URL映射规则
                            Action annotation = method.getAnnotation(Action.class);
                            String mapping = annotation.value();
                            // 验证URL映射规则
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                    // 获取请求方法与请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    // 初始化 Action Map
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 获取Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
