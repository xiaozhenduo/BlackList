package common.Exception;

/**
 * @program springboot_xzd
 * @description: 自定义异常
 * @author: 肖振铎
 * @create: 2019/07/25 12:17
 */


public class BlackException  extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public BlackException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BlackException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BlackException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BlackException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
