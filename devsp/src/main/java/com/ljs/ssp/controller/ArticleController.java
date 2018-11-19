package com.ljs.ssp.controller;

import com.ljs.ssp.domain.Article;
import com.ljs.ssp.domain.JsonData;
import com.ljs.ssp.repository.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * 功能描述：Article控制器
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/18 23:47 </p>
 */
@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    @Autowired
    private ArticleRepository repository;

    @GetMapping("save")
    public Object save() {
        Article article = new Article();
        article.setId(233L);
        article.setPv(888);
        article.setContent("this is 主要内容");
        article.setSummary("this is 概要内容");
        article.setTile("love xd class");
        repository.save(article);

        return JsonData.buildSuccess();
    }

    @GetMapping("search")
    public Object find(String title) {
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title);
        Iterable<Article> articles = repository.search(queryBuilder);

        Iterator<Article> iterator = articles.iterator();
        if (iterator.hasNext()) {
            return JsonData.buildSuccess(iterator.next());
        }

        return JsonData.buildSuccess("没有东西！");
    }

}