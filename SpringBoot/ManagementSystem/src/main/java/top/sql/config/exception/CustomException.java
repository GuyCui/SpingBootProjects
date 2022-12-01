package top.sql.config.exception;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/1 20:07
 * {@code @Description:} ManagementSystem TODO
 */
public class CustomException extends RuntimeException {
    public CustomException() {
        super();
    }
    
    public CustomException(String message) {
        super(message);
    }
    
    public CustomException(Throwable cause) {
        super(cause);
    }
    
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}