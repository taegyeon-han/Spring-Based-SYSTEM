package com.freehoon.web.profile.controller;

import java.io.File;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freehoon.web.profile.model.ProfileVO;
import com.freehoon.web.profile.service.ProfileService;
import com.freehoon.web.record.model.RecordVO;
import com.freehoon.web.record.service.RecordService;
import com.freehoon.web.user.image.upload;

@Controller
@RequestMapping(value = "/Profile")
public class EditProfile {

	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	private ProfileService ProfileService;

	@Inject
	private RecordService RecordService;

	// 개인 정보수정 로직
	@RequestMapping(value = "/UpdateProfile", method = RequestMethod.POST)
	public String EditProfiling(@ModelAttribute("ProfileVO") ProfileVO ProfileVO, MultipartFile IMG, RecordVO RecordVO,
			RedirectAttributes rttr, Model model, HttpServletRequest request, HttpSession session) throws Exception {

		ProfileVO old_data = (ProfileVO) session.getAttribute("identifier");
		String old_image = old_data.getPerson_image();
		
		String Encoded_FileName=null;
		
        String userAgent = request.getHeader("User-Agent");
        boolean ie = userAgent.indexOf("MSIE") > -1;
        if (ie) 
        {
        	Encoded_FileName = URLEncoder.encode(IMG.getName(), "utf-8").replace("+",  "%20");

        } 
        else 
        {

        	Encoded_FileName = new String(IMG.getName().getBytes("utf-8"), "iso-8859-1").replace("+", "%20");
        }


		if (IMG.getOriginalFilename().contains(".jpg") || IMG.getOriginalFilename().contains(".png")) {
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = upload.calcPath(imgUploadPath);
			String fileName = upload.fileUpload(imgUploadPath,Encoded_FileName, IMG.getBytes(), ymdPath);
			
			ProfileVO.setPerson_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);

		}

		else
		{
			ProfileVO.setPerson_image(old_image);
		} 

		String old_name = old_data.getName();
		String new_name = ProfileVO.getName();

		if (!(old_name.equals(new_name))) {
			RecordService.insert_Name_Changed(ProfileVO, session);
		}

		String old_position = old_data.getPOSITION();
		String new_position = ProfileVO.getPOSITION();

		String old_department = old_data.getDEPARTMENT();
		String new_department = ProfileVO.getDEPARTMENT();

		if (!(old_department.equals(new_department))) {

			RecordService.insert_Department_Changed(ProfileVO, session);
		}

		if (!(old_position.equals(new_position))) {
			RecordService.insert_Position_Changed(ProfileVO, session);
		}

		String old_level = old_data.getLEVEL();
		String new_level = ProfileVO.getLEVEL();

		String old_level_temp = old_level.replaceAll("[^0-9]", "");
		String new_level_temp = new_level.replaceAll("[^0-9]", "");

		if (!(old_level.equals(new_level))) {

			if (Integer.parseInt(old_level_temp) < Integer.parseInt(new_level_temp)) {
				RecordService.insert_Demote_Changed(ProfileVO, session); // 강등
			}

			else {
				RecordService.insert_Promotion_Changed(ProfileVO, session); // 승진
			}
		}

		String old_status = old_data.getSTATUS();
		String new_status = ProfileVO.getSTATUS();

		if ((new_status.equals("휴직")) && (!(new_status.equals(old_status)))) {
			RecordService.insert_Status_off(ProfileVO); // 휴직처리
		}

		if ((new_status.equals("재직")) && (!(new_status.equals(old_status)))) {
			RecordService.insert_Status_on(ProfileVO); // 복직처리
		}

		ProfileService.UpdateProfile(ProfileVO);
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));

		return "redirect:/board/ShowBoardList";
	}

}
