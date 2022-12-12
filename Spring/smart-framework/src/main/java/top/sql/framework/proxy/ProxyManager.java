package top.sql.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.List;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/12 20:41
 * {@code @Description:} smart-framework 代理管理类
 */
public class ProxyManager {
    /**
     * 创建代理
     */
    @SuppressWarnings("uncheckd")
    public static <T> T createProxy(final Class<?> targetClass,
                                    final List<Proxy> proxyList) {
        return (T) Enhancer.create(targetClass,
                (MethodInterceptor) (tatgetObject, targetMethod, targetParams
                        , methodProxy) -> new ProxyChain(targetClass,
                        tatgetObject, targetMethod, methodProxy, targetParams
                        , proxyList).doProxyChain());
    }
}
