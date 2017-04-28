/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.lyg.cloud.model.BxBooks;

@Component("elasticBxBooksRepository")
public interface ElasticBxBooksRepository  extends ElasticsearchRepository<BxBooks,String> {
    //TODO define the search
	List<BxBooks> findByBookTitle(String bookTitle);
}
