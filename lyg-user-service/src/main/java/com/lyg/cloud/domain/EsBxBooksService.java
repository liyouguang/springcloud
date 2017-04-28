/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.cloud.model.BxBooks;
import com.lyg.cloud.repository.ElasticBxBooksRepository;

@Service
public class EsBxBooksService {

	@Autowired
    private ElasticBxBooksRepository elasticBxBooksRepository;

    public BxBooks queryBxBookById(String id) {
        return elasticBxBooksRepository.findOne(id);
    }

    public List<BxBooks> queryBxBooksByName(String bookTitle) {
        return elasticBxBooksRepository.findByBookTitle(bookTitle);
    }
}
