package top.sql.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/8 19:43
 * {@code @Description:} smart-framework 封装请求信息
 */
public class Request {
    /**
     * 请求方法
     */
    private String requestMethod;
    
    /**
     * 请求路径
     */
    private String requestPath;
    
    /**
     * 有参构造
     */
    public Request(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }
    
    /**
     * 获取请求方法
     */
    public String getRequestMethod() {
        return requestMethod;
    }
    
    /**
     * 获取请求路径
     */
    public String getRequestPath() {
        return requestPath;
    }
    
    /**
     * 重写hashCode
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    /**
     * 重写equals方法
     */
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
