package com.liyang.jpa.audit.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/${spring.jpa.restful.audit.search-path}")
public class SearchController {

	@Autowired
	protected MongoTemplate mongoTemplate;
	
	@Value("${spring.jpa.restful.audit.search-path}")
	private String searchPath;
	
	@RequestMapping(path="",method=RequestMethod.GET)
	public String list(@RequestParam(required=false) String uuid, Pageable pageable , Model model) {
		
		model.addAttribute("searchPath",searchPath);
		model.addAttribute("items", new ArrayList());
		if(uuid!=null) {
			Query query = new Query();
			query.addCriteria(Criteria.where("ownerUuid").is(uuid));
			query.with(new Sort(Sort.Direction.DESC, "createAt"));		
			query.with(pageable);
			List<AuditLog> items = mongoTemplate.find(query, AuditLog.class);
			model.addAttribute("items", items);
		}
		
		return "audit_search";
	}

}
