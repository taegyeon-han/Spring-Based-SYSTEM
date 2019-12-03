package com.freehoon.web.user.controller;

import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.service.IDService;

@Controller
@RequestMapping(value = "/login")
public class userIDCreate 
{
	
	private static final Logger logger = LoggerFactory.getLogger(userIDCreate.class);
	
	@Inject
	private IDService IDService;
	//가입하기
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute("IDVO") IDVO IDVO
			, RedirectAttributes rttr) throws Exception {
		 IDService.insertUser(IDVO);
	
		return "redirect:/login";
	}

	
}

 
