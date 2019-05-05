package com.liyang.jpa.audit.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.liyang.jpa.audit.server.common.HTTPListResponse;
import com.liyang.jpa.audit.server.domain.AuditLog;

@RestController
public class AuditApiController {
	
	@Autowired
	protected MongoTemplate mongoTemplate;
	
	@Value("${spring.data.mongodb.uri}")
	private String dataSource;


	@RequestMapping(path="/api",method=RequestMethod.POST)
	public String add(@RequestBody AuditLog log) {
		AuditLog insert = mongoTemplate.insert(log, "logs");
		return "ok";
	}
	@RequestMapping(path="/api/{uuid}",method=RequestMethod.GET)
	@ResponseBody
	public Object list(@PathVariable String uuid, Pageable pageable) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("uuid").is(uuid));
		query.with(new Sort(Sort.Direction.DESC, "createdAt"));		
		query.with(pageable);
		long total = mongoTemplate.count(query, AuditLog.class);
		List<AuditLog> items = mongoTemplate.find(query, AuditLog.class);
		return new HTTPListResponse(items, total, pageable.getPageNumber(), pageable.getPageSize());
	}
	@RequestMapping(path="/list",method=RequestMethod.GET)
	@ResponseBody
	public Object listAll(Pageable pageable) {
		
		Query query = new Query();
		
		query.with(new Sort(Sort.Direction.DESC, "createdAt"));		
		query.with(pageable);
		long total = mongoTemplate.count(query, AuditLog.class);
		List<AuditLog> items = mongoTemplate.find(query, AuditLog.class);
		return new HTTPListResponse(items, total, pageable.getPageNumber(), pageable.getPageSize());
	}
	
	
}
