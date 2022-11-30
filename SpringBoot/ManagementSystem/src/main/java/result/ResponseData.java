package result;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 22:40
 * {@code @Description:} ManagementSystem TODO
 */
public class ResponseData extends Response {
    private Object data;
    
    public ResponseData(Object data) {
        this.data = data;
    }
    
    public ResponseData(ExceptionMsg msg) {
        super(msg);
    }
    
    public ResponseData(String rspCode, String rspMsg) {
        super(rspCode, rspMsg);
    }
    
    public ResponseData(String rspCode, String rspMsg, Object data) {
        super(rspCode, rspMsg);
        this.data = data;
    }
    
    public ResponseData(ExceptionMsg msg, Object data) {
        super(msg);
        this.data = data;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "ResponseData{" + "data=" + data + "} " + super.toString();
    }
}