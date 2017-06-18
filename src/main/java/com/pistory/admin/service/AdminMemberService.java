package com.pistory.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pistory.admin.dao.AdminMemberDAO;

@Service
public class AdminMemberService {
	private static final String SECRET_KEY = "100sohyun";
	private PasswordEncoder passwordEncoder = new StandardPasswordEncoder(SECRET_KEY);
	
	@Autowired
	private AdminMemberDAO adminMemberDAO;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminMemberDAO.class);
	
	public boolean isValidMember(String userId, String userPw) {
		String realPw = adminMemberDAO.selectUserPw(userId);
		
		if (realPw != userPw) {
			return false;
		}
		
		return true;
	}
	
	public String getUid(String userId) {
		return adminMemberDAO.selectUid(userId);
	}
}
