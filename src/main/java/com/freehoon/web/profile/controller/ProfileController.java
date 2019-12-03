package com.freehoon.web.profile.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.File;
import java.net.URLEncoder;

import com.freehoon.web.profile.model.ProfileVO;
import com.freehoon.web.profile.service.ProfileService;
import com.freehoon.web.record.model.RecordVO;
import com.freehoon.web.record.service.RecordService;
import com.freehoon.web.user.image.upload;

@Controller
@RequestMapping(value = "/Profile")
public class ProfileController {

	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	private ProfileService ProfileService;

	@Inject
	private RecordService RecordService;

	@RequestMapping(value = "/EditProfile")
	public String EditProfile(Model model, HttpServletRequest request) {
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		return "Profile/EditProfile";

	}

	@RequestMapping(value = "/CreateProfile")
	public String CreateProfileMenu(@ModelAttribute("ProfileVO") ProfileVO ProfileVO, Model model,
			HttpServletRequest request) {
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		return "Profile/CreateProfile";
	}

	// �����ϱ�
	@RequestMapping(value = "/CreateProfiling", method = RequestMethod.POST)
	public String CreateProfile(@ModelAttribute("ProfileVO") ProfileVO ProfileVO, MultipartFile IMG,
			RedirectAttributes rttr, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws Exception {

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
			String fileName = upload.fileUpload(imgUploadPath, Encoded_FileName , IMG.getBytes(), ymdPath);
			
			ProfileVO.setPerson_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);

		}

		else
		{
			ProfileVO.setPerson_image(null);
		}

		ProfileService.insertBasicProfile(ProfileVO);
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));

		redirectAttributes.addFlashAttribute("msg", "�λ� ������ �ԷµǾ����ϴ�");

		return "redirect:/board/userList";
	}

	// �ٸ� ���� ���� ���� ����
	@RequestMapping(value = "/UserProfile")
	public String getOtherProfile(Model model, HttpServletRequest request,
			@RequestParam("identifier") String identifier) throws Exception {

		model.addAttribute("identifier", ProfileService.getOtherProfile(identifier)); // �ٸ� ���� ������ ��ȸ
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		model.addAttribute("record", RecordService.ShowRecordList(identifier)); // �����λ����� ��ȸ
		return "Profile/UserProfile";
	}

	// ���� �������� â���� ����
	@RequestMapping(value = "/EditProfile", method = RequestMethod.POST)
	public String EditProfile(@ModelAttribute("ProfileVO") ProfileVO ProfileVO, Model model, HttpServletRequest request,
			HttpSession session, String identifier) throws Exception {
		session.setAttribute("identifier", ProfileService.getOtherProfile(identifier));
		model.addAttribute("identifier", ProfileService.getOtherProfile(identifier)); // �ٸ� ���� ������ ��ȸ
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		model.addAttribute("record", RecordService.ShowRecordList(identifier)); // �����λ����� ��ȸ

		return "Profile/EditProfile";
	}

	@RequestMapping(value = "/deletingProfile", method = RequestMethod.POST)
	public String deleteProfile(ProfileVO ProfileVO, Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		ProfileService.deleteProfile(ProfileVO);
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		redirectAttributes.addFlashAttribute("msg", "���� �Ǿ����ϴ�.");

		return "redirect:/board/userList";
	}

	@RequestMapping(value = "/deleteRecord", method = RequestMethod.GET)
	public String deleteRecord(ProfileVO ProfileVO, Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes redirectAttributes, int bid) throws Exception {
		RecordService.deleteRecord(bid);
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		redirectAttributes.addFlashAttribute("msg", "���� �Ǿ����ϴ�.");

		return "redirect:/board/userList";
	}

	@RequestMapping(value = "/EditRecord", method = RequestMethod.GET)
	public String editRecord(Model model, @RequestParam("bid") int bid) throws Exception {
		model.addAttribute("record", RecordService.ShowEditRecord(bid));
		return "Profile/EditRecord";
	}

	@RequestMapping(value = "/EditingRecord", method = RequestMethod.POST)
	public String editingRecord(Model model, RecordVO RecordVO) throws Exception {
		RecordService.updateRecord(RecordVO);
		return "redirect:/Profile/userList";
	}
}