package top.sql.framework.proxy;


import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/12 20:10
 * {@code @Description:} smart-framework 代理链
 */
public class ProxyChan {
    private final Class<?> targetClass;
    private final Object targetObject;
    private final Method targetMethod;
    private final MethodProxy methodProxy;
    private final Object[] methodParams;
    private List<Proxy> proxyList = new ArrayList<>();
    private int proxyIndex = 0;
    
    public ProxyChan(Class<?> targetClass, Object targetObject, Method targetMethod, MethodProxy methodProxy, Object[] methodParams,
                     List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.methodParams = methodParams;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.proxyList = proxyList;
    }
    
    public Class<?> getTargetClass() {
        return targetClass;
    }
    
    public Method getTargetMethod() {
        return targetMethod;
    }
    
    public Object[] getMethodParams() {
        return methodParams;
    }
    
    public Object doProxyChain() throws Throwable {
        Object methodResult;
        if (proxyIndex < proxyList.size()) {
            methodResult = proxyList.get(proxyIndex++).doProxy(this);
        } else {
            methodResult = methodProxy.invokeSuper(targetObject, methodParams);
        }
        return methodResult;
    }
}
