package com.freehoon.web.login.controller;

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
import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.login.model.RestPassWordVO;
import com.freehoon.web.login.service.IDService;
import com.freehoon.web.profile.service.ProfileService;
import com.freehoon.web.user.controller.userListController;

@Controller
@RequestMapping(value = "/id")

public class idResetController 
{
	
	
private static final Logger logger = LoggerFactory.getLogger(idResetController.class);
	
	@Inject
	private IDService IDService;
	
	//���� ��� ����
	@RequestMapping(value = "/IDList", method = RequestMethod.GET)
	public String getUserList(Model model,  HttpServletRequest request, LoginVO LoginVO) throws Exception {
		// ��ü �Խñ� ����

        model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		model.addAttribute("IDList", IDService.getIDUserList());

				
		return "id/IDList";
	}
	
	//��й�ȣ �ʱ�ȭ â ����
	@RequestMapping(value = "/RestPassWord", method = RequestMethod.GET)
	public String RestPassWord(Model model,  HttpServletRequest request, 
			@RequestParam(required = false) String identifier,  RestPassWordVO  RestPassWordVO) throws Exception {
		
        model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		model.addAttribute("IDVO", IDService.ResetPassWord( RestPassWordVO ));
				
		return "id/RestPassWord";
	}
	
	//��й�ȣ �ʱ�ȭ �ϱ�
	@RequestMapping(value = "/Reseting", method = RequestMethod.POST)
	public String RestPassWord(Model model,  HttpServletRequest request, RestPassWordVO RestPassWordVO) throws Exception {
		
        model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		IDService.ResetingPassWord(RestPassWordVO);
				
		return "redirect:/id/IDList";
	}
	
	
	

}
