package net.xdclass.demo.bean;

/**
 * 响应实体
 */
public class ResponseDTO {

    //响应码（0：成功；-1：失败）
    private Integer code;

    //错误信息
    private String msg;

    //响应数据
    private Object data;

    public ResponseDTO(Object data) {
        super();
        this.code = 0;
        this.msg = "";
        this.data = data;
    }

    public ResponseDTO(String msg) {
        super();
        this.code = -1;
        this.msg = msg;
        this.data = null;
    }

    public ResponseDTO(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
