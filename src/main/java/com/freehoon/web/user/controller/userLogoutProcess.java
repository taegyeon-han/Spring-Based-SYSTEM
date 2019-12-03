package com.freehoon.web.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;

@Controller
@RequestMapping(value = "/board")
public class userLogoutProcess {

	@RequestMapping(value = "/logout.do")
	public String logout(@ModelAttribute("LoginVO") LoginVO LoginVO, HttpServletRequest request)
			throws Exception {

	
		request.getSession().removeAttribute("LoginVO");

	    return "redirect:/login";
	}

}
