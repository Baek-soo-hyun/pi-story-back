package com.pistory.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pistory.admin.service.AdminCategoryService;

@RestController
@RequestMapping("/api/admin/category")
public class AdminCategoryController {

	@Autowired
	private AdminCategoryService adminCategoryService;
	
	private static final String userPassword = "100sohyun";
	
	@RequestMapping("/list")
	public Map getlist(@RequestParam("currentPage") int currentPage,
			@RequestParam("rowsPerPage") int rowsPerPage) {
		
		List list = adminCategoryService.getList(currentPage, rowsPerPage);
		int count = adminCategoryService.countList();
		
		Map result = new HashMap();
		result.put("list", list);
		result.put("count", count);
		
		return result;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Map add(@RequestParam("categoryName") String categoryName,
			@RequestParam("password") String password) {
		
		if(password == userPassword) {
			adminCategoryService.add(categoryName);
			
			Map result = new HashMap();
			result.put(result, "ok");
		
			return result;
		}
		
		Map result = new HashMap();
		result.put(result, "no");
	
		return result;
	}
	
	@RequestMapping(value="/{categoryId}", method=RequestMethod.GET)
	public Map get(@PathVariable("categoryId") String categoryId) {
		
		return adminCategoryService.get(categoryId);
	}
	
	@RequestMapping(value="/{categoryId}", method=RequestMethod.PUT)
	public Map modify(@PathVariable("categoryId") String categoryId,
			@RequestParam("categoryName") String categoryName) {
		
		adminCategoryService.modify(categoryId, categoryName);
		
		Map result = new HashMap();
		result.put(result, "ok");
	
		return result;
	}
	
	@RequestMapping(value="/{categoryId}", method=RequestMethod.DELETE)
	public Map remove(@PathVariable("categoryId") String categoryId) {
		
		adminCategoryService.remove(categoryId);
		
		Map result = new HashMap();
		result.put(result, "ok");
	
		return result;
	}
}
