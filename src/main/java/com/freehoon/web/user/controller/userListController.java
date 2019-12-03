package com.freehoon.web.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.freehoon.web.Search;
import com.freehoon.web.login.service.IDService;

@Controller
@RequestMapping(value = "/board")
public class userListController 
{
	
	private static final Logger logger = LoggerFactory.getLogger(userListController.class);
	
	@Inject
	private IDService IDService;
	
	//���� ��� ����
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String getUserList(Model model,  HttpServletRequest request, 
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String keyword) throws Exception {
		// ��ü �Խñ� ����
		
		
		Search search = new Search();
	
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		int listCnt = IDService.getUserListCnt(search);
		search.pageInfo(page, range, listCnt);
		
        model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		model.addAttribute("pagination", search);	
		model.addAttribute("userList", IDService.getUserList(search));
				
		return "board/userList";
	}
}

 
