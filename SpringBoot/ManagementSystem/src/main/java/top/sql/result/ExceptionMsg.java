package top.sql.result;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/11/30 22:36
 * {@code @Description:} ManagementSystem TODO
 */
public enum ExceptionMsg {
    /**
     * 成功
     */
    SUCCESS("200", "操作成功"),
    /**
     * 失败
     */
    FAILED("999999", "操作失败"),
    /**
     * 参数错误
     */
    ParamError("000001", "参数错误！"),
    /**
     * 登录信息错误
     */
    LoginNameOrPassWordError("000100", "用户名或者密码错误！"),
    /**
     * 上传为空
     */
    FileEmpty("000400", "上传文件为空"),
    /**
     * 图片过大
     */
    LimitPictureSize("000401", "图片大小必须小于2M"),
    /**
     * 图片格式
     */
    LimitPictureType("000402", "图片格式必须为'jpg'、'png'、'jpge'、'gif'、'bmp'");
    
    /**
     * 编码
     */
    private final String code;
    /**
     * 内容
     */
    private final String msg;
    private ExceptionMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getMsg() {
        return msg;
    }
}