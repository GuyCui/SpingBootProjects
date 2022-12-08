package top.sql.framework.bean;

import java.lang.reflect.Method;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/8 20:50
 * {@code @Description:} smart-framework 封装Action信息
 */
public class Handler {
    /**
     * Controller类
     */
    private Class<?> controllerClass;
    
    /**
     * Action方法
     */
    private Method actionMethod;
    
    /**
     * Handler 有参构造
     */
    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }
    
    public Class<?> getControllerClass() {
        return controllerClass;
    }
    
    public Method getActionMethod() {
        return actionMethod;
    }
}
