package net.xdclass.demo.domain;

/**
 * 自定义异常类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/3 </p>
 */
public class MyException extends RuntimeException {

    /**
     * 状态码
     */
    private String code;

    /**
     * 异常信息
     */
    private String msg;

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
