package com.pistory.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pistory.admin.service.AdminMemberService;

@RestController
public class AdminMemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminMemberController.class);
	
	@Autowired
	private AdminMemberService adminMemberService;
	
	
	@RequestMapping(value="/api/member/signIn", method=RequestMethod.POST)
	public Map signIn(@RequestParam("userId") String userId, 
					  @RequestParam("userPw") String userPw,
					  HttpServletRequest request) {
		  String uid = adminMemberService.getUid(userId);
	      
	      try {
	          if(!adminMemberService.isValidMember(userId, userPw)) {
	             throw new RuntimeException("Password를 확인해주세요.");
	          }
	       }
	       catch (NullPointerException e) {
	          throw new RuntimeException("가입되지 않은 사용자입니다.");
	       }
	      
	      //로그인 세션 저장//
	      HttpSession session = request.getSession();
	     
	      session.setAttribute("signedIn", true);
	      session.setAttribute("uid", uid);
	      session.setAttribute("userId", userId);
		
		  Map result = new HashMap();
		  result.put("result", "ok");		
		  return result;
	}
	
   @RequestMapping("/api/member/signedIn")
   public Map signedin(HttpSession session) {
      Map result = new HashMap();
      String signedIn = "no";      
      
      if (session.getAttribute("signedIn") != null &&
            (Boolean) session.getAttribute("signedIn")) {
         signedIn = "yes";
         
         result.put("userId", session.getAttribute("uid"));
         result.put("userId", session.getAttribute("userId"));
      }
      
      result.put("result", signedIn);
      result.put("userRank", session.getAttribute("userRank"));
      result.put("uid", session.getAttribute("uid"));
 
      return result;
   }
}
