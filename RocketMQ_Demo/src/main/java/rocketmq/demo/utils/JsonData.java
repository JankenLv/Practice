package rocketmq.demo.utils;

import java.io.Serializable;

/**
 * 功能描述：响应结果类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/10 20:54 </p>
 */
public class JsonData implements Serializable {

    private Integer code;// 状态码  0：成功；1：处理中；-1：失败

    private Object data;// 数据

    private String msg;// 描述

    public JsonData() {
    }

    public JsonData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    // 成功，传入数据
    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }

    // 成功，传入数据
    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, null);
    }

    // 成功，传入描述信息
    public static JsonData buildSuccess(String msg) {
        return new JsonData(0, null, msg);
    }

    // 成功，传入数据和描述信息
    public static JsonData buildSuccess(Object data, String msg) {
        return new JsonData(0, data, msg);
    }

    // 成功，传入状态码和描述信息
    public static JsonData buildSuccess(Integer code, String msg) {
        return new JsonData(code, null, msg);
    }

    // 失败，传入数据
    public static JsonData buildError(Object data) {
        return new JsonData(-1, data, null);
    }

    // 失败，传入描述信息
    public static JsonData buildError(String msg) {
        return new JsonData(-1, null, msg);
    }

    // 失败，传入数据和描述信息
    public static JsonData buildError(Object data, String msg) {
        return new JsonData(-1, data, msg);
    }

    // 失败，传入状态码描述信息
    public static JsonData buildError(Integer code, String msg) {
        return new JsonData(code, null, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
