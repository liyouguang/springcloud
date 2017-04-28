/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "testbook",type = "testb", shards = 1,replicas = 0, refreshInterval = "-1")
public class BxBooks {
	
	@Id
	private Integer id;
	
	private String ISBN;
	
	private String bookTitle;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	@Override
	public String toString() {
		return "BxBooks [id=" + id + ", ISBN=" + ISBN + ", bookTitle=" + bookTitle + "]";
	}

	
}
