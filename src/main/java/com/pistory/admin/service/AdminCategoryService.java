package com.pistory.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pistory.admin.dao.AdminCategoryDAO;
import com.pistory.util.KeyUtils;

@Service
public class AdminCategoryService {

	@Autowired
	private AdminCategoryDAO adminCategoryDAO;
	
	public List getList(int currentPage, int rowsPerPage) {
		return adminCategoryDAO.selectList(currentPage, rowsPerPage);
	}
	
	public int countList() {
		return adminCategoryDAO.countList();
	}
	
	public Map get(String categoryId) {
		return adminCategoryDAO.selectOne(categoryId);
	}
	
	public int modify(String categoryId, String categoryName) {
		return adminCategoryDAO.update(categoryId, categoryName);
	}	
	
	public int remove(String categoryId) {
		return adminCategoryDAO.delete(categoryId);
	}
	
	public int add(String categoryName) {
		String categoryId = KeyUtils.generateKey("CAT");
		return adminCategoryDAO.insert(categoryId, categoryName);
	}	
}
