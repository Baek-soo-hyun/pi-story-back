package com.pistory.admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminMemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminMemberDAO.class);
	
	public String selectUserPw(String userId){
		return sqlSession.selectOne("adminMember.selectUserPw", userId);
	}
	
	public String selectUid(String userId) {
		return sqlSession.selectOne("adminMember.selectUid", userId);
	}
}
