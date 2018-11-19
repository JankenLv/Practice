package com.ljs.ssp.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 功能描述：文章对象
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/18 22:52 </p>
 */
@Document(indexName = "blog", type = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = 5631332717065385190L;

    private long id;

    private String title;

    private String summary;

    private String content;

    private int pv;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", pv=" + pv +
                '}';
    }
}
