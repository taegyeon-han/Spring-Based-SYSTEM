package com.freehoon.web.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.login.service.IDService;
import com.freehoon.web.profile.model.ProfileVO;
import com.freehoon.web.profile.service.ProfileService;

@Controller
@RequestMapping(value = "/")

public class loginController {
	
	@Inject
	private ProfileService ProfileService;

	@Inject
	private IDService IDService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	//�α��� â���� �̵�
	public String loginForm(Model model) throws Exception {
		model.addAttribute("LoginVO", new LoginVO());
		return "login/login";
	}
	

	//���� â���� �̵�
	@RequestMapping(value = "/signup")
	public String signup(Model model) throws Exception 
	{
		model.addAttribute("IDVO", new IDVO());
		model.addAttribute("ProfileVO", new ProfileVO());
		return "login/signup";
	}

	// �������� �˻�
	@RequestMapping(value = "/SearchID", method = RequestMethod.POST)
	public String SearchProfile(ProfileVO ProfileVO, HttpServletRequest request, RedirectAttributes redirectAttributes,
			Model model) throws Exception {

		ProfileVO Result2VO = new ProfileVO();
		ProfileVO ResultVO = new ProfileVO();
		ResultVO = ProfileService.SearchID(ProfileVO);
		Result2VO = IDService.IDCheck(ProfileVO);

		if (ResultVO != null) {
			if (Result2VO != null) {
				redirectAttributes.addFlashAttribute("msg", "�̹� �λ�ý��ۿ� ���ԵǾ����ϴ�.");
				return "redirect:/login";
			}

			else {
				request.getSession().setAttribute("ProfileVO", ResultVO);
				redirectAttributes.addFlashAttribute("DBDATA", request.getSession().getAttribute("ProfileVO"));
				return "redirect:/signup";
			}
		}

		else {
			redirectAttributes.addFlashAttribute("msg", "�������� ��ȣ�� �������� �ʽ��ϴ� �������� �����Ͻʽÿ�");
			return "redirect:/login";
		}

	}

}
