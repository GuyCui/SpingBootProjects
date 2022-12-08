package top.sql.framework.bean;

import top.sql.framework.util.CastUtil;

import java.util.Map;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/8 21:27
 * {@code @Description:} smart-framework 请求参数对象
 */
public class Param {
    private Map<String, Object> paramMap;
    
    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }
    
    /**
     * 根据参数名获取long类型参数值
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }
    
    /**
     * 获取所有字段信息
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }
}
