package com.liyang.jpa.audit.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyang.jpa.audit.server.domain.AuditLog;

@Controller
public class SearchController {

	@Autowired
	protected MongoTemplate mongoTemplate;
	
	@RequestMapping(path="/search",method=RequestMethod.GET)
	public String list(@RequestParam String uuid, Pageable pageable , Model model) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("ownerUuid").is(uuid));
		query.with(new Sort(Sort.Direction.DESC, "createAt"));		
		query.with(pageable);
		List<AuditLog> items = mongoTemplate.find(query, AuditLog.class);
		model.addAttribute("items", items);
		return "audit_search";
	}
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String list() {
		return "audit_search";
	}
}
