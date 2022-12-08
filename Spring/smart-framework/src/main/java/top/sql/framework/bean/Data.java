package top.sql.framework.bean;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/8 21:39
 * {@code @Description:} smart-framework 返回数据对象
 */
public class Data {
    /**
     * 数据模型
     */
    private Object model;
    
    public Data(Object model) {
        this.model = model;
    }
    
    public Object getModel() {
        return model;
    }
}
