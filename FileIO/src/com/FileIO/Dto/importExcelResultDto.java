package com.FileIO.Dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储导入的excel文件数据的Dto
 * 描述标题title、表格数据sheet、异常信息exceptionMsg
 */
@SuppressWarnings("unused")
public class importExcelResultDto {
    private String title;
    private String exceptionMsg;
    private List<List<String>> sheet;

    public importExcelResultDto(){
        title = null;
        exceptionMsg = null;
        sheet = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public void setSheet(List<List<String>> sheet) {
        this.sheet = sheet;
    }

    public List<List<String>> getSheet() {
        return sheet;
    }
}
