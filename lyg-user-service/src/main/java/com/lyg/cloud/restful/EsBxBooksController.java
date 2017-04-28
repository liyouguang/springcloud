/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.EsBxBooksService;

@RestController
@RequestMapping("/bb")
public class EsBxBooksController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EsBxBooksController.class);
	@Autowired  
    private EsBxBooksService esBxBooksService;  
	
    @RequestMapping(value = "/{id}/bxboox", method = RequestMethod.GET)  
    public Object getBxBookDetail(@PathVariable(value="id")  String id)  {
    	LOGGER.debug("搜索引擎，根据id查询对象..");
        return esBxBooksService.queryBxBookById(id);  
    }  
	

    @RequestMapping(value = "/{bookTitle}/list", method = RequestMethod.GET)  
    public Object getBxBooks(@PathVariable(value="bookTitle")   String bookTitle)  {  
        return esBxBooksService.queryBxBooksByName(bookTitle);  
    }
}
