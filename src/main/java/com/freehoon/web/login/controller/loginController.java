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
	//로그인 창으로 이동
	public String loginForm(Model model) throws Exception {
		model.addAttribute("LoginVO", new LoginVO());
		return "login/login";
	}
	

	//가입 창으로 이동
	@RequestMapping(value = "/signup")
	public String signup(Model model) throws Exception 
	{
		model.addAttribute("IDVO", new IDVO());
		model.addAttribute("ProfileVO", new ProfileVO());
		return "login/signup";
	}

	// 공무원증 검색
	@RequestMapping(value = "/SearchID", method = RequestMethod.POST)
	public String SearchProfile(ProfileVO ProfileVO, HttpServletRequest request, RedirectAttributes redirectAttributes,
			Model model) throws Exception {

		ProfileVO Result2VO = new ProfileVO();
		ProfileVO ResultVO = new ProfileVO();
		ResultVO = ProfileService.SearchID(ProfileVO);
		Result2VO = IDService.IDCheck(ProfileVO);

		if (ResultVO != null) {
			if (Result2VO != null) {
				redirectAttributes.addFlashAttribute("msg", "이미 인사시스템에 가입되었습니다.");
				return "redirect:/login";
			}

			else {
				request.getSession().setAttribute("ProfileVO", ResultVO);
				redirectAttributes.addFlashAttribute("DBDATA", request.getSession().getAttribute("ProfileVO"));
				return "redirect:/signup";
			}
		}

		else {
			redirectAttributes.addFlashAttribute("msg", "공무원증 번호가 존재하지 않습니다 담당관에게 문의하십시오");
			return "redirect:/login";
		}

	}

}
