package com.freehoon.web.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;

@Controller
@RequestMapping(value = "/")

public class loginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	//�α��� â���� �̵�
	public String loginForm(Model model) throws Exception {
		model.addAttribute("LoginVO", new LoginVO());
		return "login/login";
	}
	

	//���� â���� �̵�
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) throws Exception 
	{
		model.addAttribute("IDVO", new IDVO());
		return "login/signup";
	}

}
