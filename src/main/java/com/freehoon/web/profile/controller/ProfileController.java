package com.freehoon.web.profile.controller;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.login.service.IDService;
import com.freehoon.web.profile.model.ProfileVO;
import com.freehoon.web.profile.service.ProfileService;
import com.freehoon.web.record.model.RecordVO;
import com.freehoon.web.record.service.*;

@Controller
@RequestMapping(value = "/Profile")
public class ProfileController {

	@Inject
	private ProfileService ProfileService;
	
	@Inject
	private IDService IDService;
	
	@Inject
	private RecordService RecordService;
	
	@RequestMapping(value = "/EditMyProfile")
	public String EditMyProfileMenu(Model model, HttpServletRequest request, LoginVO LoginVO, ProfileVO ProfileVO)
			throws Exception 
	{
		ProfileVO ResultVO = new ProfileVO();
		ResultVO = ProfileService.getMyProfile(model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO")));

		request.getSession().setAttribute("ProfileVO", ResultVO);

		model.addAttribute("Profile", request.getSession().getAttribute("ProfileVO"));
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		return "Profile/EditMyProfile";

	}

	
	//개인정보 수정
	@RequestMapping(value = "/UpdateUser")
	public String UpdateUser(Model model, HttpServletRequest request, LoginVO LoginVO, IDVO IDVO, ProfileVO ProfileVO)
			throws Exception {

		ProfileService.UpdateUserProfile(ProfileVO);
		IDService.updateUser(IDVO);
		
		model.addAttribute("Profile", request.getSession().getAttribute("ProfileVO"));
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));

		return "redirect:/Profile/MyProfile";

	}
	
	@RequestMapping(value = "/MyProfile")
	public String CreateProfileMenu(Model model, HttpServletRequest request, LoginVO LoginVO, ProfileVO ProfileVO)
			throws Exception {

		ProfileVO ResultVO = new ProfileVO();
		List<RecordVO> ResultVO2 = new ArrayList<RecordVO>();
		
		ResultVO = ProfileService.getMyProfile(model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO")));
		ResultVO2 = RecordService.ShowRecordList(model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO")));
		
		request.getSession().setAttribute("ProfileVO", ResultVO);
		request.getSession().setAttribute("RecordVO", ResultVO2);

	    model.addAttribute("record", request.getSession().getAttribute("RecordVO")); 
		model.addAttribute("Profile", request.getSession().getAttribute("ProfileVO"));
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
	    
		return "Profile/MyProfile";

	}
	
	// 다른 직원 상제 정보 보기
	@RequestMapping(value = "/UserProfile")
	public String getOtherProfile(Model model, HttpServletRequest request, @RequestParam("identifier") String identifier) throws Exception {
		
		model.addAttribute("identifier", ProfileService.getOtherProfile(identifier)); // 다른 직원 상세정보 조회
        model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));

		return "Profile/UserProfile";
	}


}