package top.sql.framework;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/5 23:12
 * {@code @Description:} smart-framework 提供相关配置项常量
 */
public interface ConfigConstant {
    String CONFIG_FILE = "smart.properties";
    
    String JDBC_DRIVER = "smart.framework.jdbc.url";
    
    String JDBC_USERNAME = "smart.framework.jdbc.username";
    
    String JDBC_PASSWORD = "smart.framework.jdbc.password";
    
    String APP_BASE_PACKAGE = "smart.framework.app.base_package";
    
    String APP_JSP_PATH = "smart.framework.app.jsp_path";
    
    String APP_ASSET_PATH = "smart.framework.app.asset_path";
}