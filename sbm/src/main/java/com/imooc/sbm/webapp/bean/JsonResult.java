package com.imooc.sbm.webapp.bean;

import com.alibaba.fastjson.JSON;

public class JsonResult {

    private String status;
    private String errorCode;
    private Object data;

    public JsonResult() {

    }

    public JsonResult(String status, String errorCode, Object data) {
        this.status = status;
        this.errorCode = errorCode;
        this.data = data;
    }

    public static Object render(Object data) {
        return JSON.toJSON(new JsonResult("成功",null,data));
    }

    public static Object render(String errorCode) {
        return JSON.toJSON(new JsonResult("失败",errorCode,null));
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
