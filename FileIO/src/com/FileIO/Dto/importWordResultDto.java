package com.FileIO.Dto;

/**
 * 存储导入的word文件的Dto
 * 描述标题title、文档内容content、异常信息exceptionMsg
 */
public class importWordResultDto {
    private String title;
    private String content;
    private String exceptionMsg;

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
