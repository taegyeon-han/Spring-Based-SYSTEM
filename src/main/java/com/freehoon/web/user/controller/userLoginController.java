package com.freehoon.web.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.login.service.IDService;

@Controller
public class userLoginController 
{

	   @Autowired
	    private IDService mainServiceImpl;
	    
	    @RequestMapping(value="/error.do")
	    public String mainPage(RedirectAttributes redirectAttributes) throws Exception{
	        
	    	  
	    	redirectAttributes.addFlashAttribute("msg", "�α����� �ʿ��մϴ�.");
	        return "redirect:/login";
	    }
	    
	    @RequestMapping(value="/loginprocess.do")
	    public String login(@ModelAttribute("LoginVO") LoginVO loginVO,
	            HttpServletRequest request, 
	            RedirectAttributes redirectAttributes, Model model) throws Exception{
	    	
	        LoginVO resultVO = new LoginVO();
	        resultVO = mainServiceImpl.LoginProcess(loginVO);
	        
	               
	        if(resultVO != null)
	        {    
	            request.getSession().setAttribute("LoginVO", resultVO);
	            return "forward:/board/ShowBoardList";
	            
	        } else {
	            
	        	redirectAttributes.addFlashAttribute("msg", "ID Ȥ�� �н����尡 ��ġ���� �ʽ��ϴ�.");
	            return "redirect:/login";
	            
	        }
	    }
}