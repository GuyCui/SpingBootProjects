package top.sql.framework.proxy;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/12 20:07
 * {@code @Description:} smart-framework 代理接口
 */
public interface Proxy {
    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
