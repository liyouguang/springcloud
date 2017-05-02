package com.lyg.cloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.service.ReportService;

@RestController
public class ReportController {

	    @Autowired
	    private ReportService reportService;

	   @RequestMapping(value = "/list", method = RequestMethod.GET)
	    public String list() {
	        return reportService.addService();
	    }
}