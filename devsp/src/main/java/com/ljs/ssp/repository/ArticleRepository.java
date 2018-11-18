package com.ljs.ssp.repository;

import com.ljs.ssp.domain.Article;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * 功能描述：Article持久化接口
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/18 23:11 </p>
 */
@Component
@Document(indexName = "blog", type = "article", shards = 1, replicas = 0)
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
}
