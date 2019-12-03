package com.freehoon.web.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freehoon.web.Search;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.board.service.BoardService;
import com.freehoon.web.login.dao.IDDao;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.login.service.IDService;
import com.freehoon.web.profile.model.ProfileVO;
import com.mysql.cj.Session;

@Controller
@RequestMapping(value = "/board")

public class BoardController {

	
	// ȭ�鿡 �� ����Ʈ �����ֱ�
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/ShowBoardList")
	public String ShowBoardList(Model model,  HttpServletRequest request, 
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String keyword) throws Exception {
		// ��ü �Խñ� ����
		
		Search search = new Search();
	
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		int listCnt = boardService.getBoardListCnt(search);
		search.pageInfo(page, range, listCnt);
		
        model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		model.addAttribute("pagination", search);	
		model.addAttribute("boardList", boardService.ShowBoardList(search));
		return "board/Index";

	}

	// �� ���� ���� �� ��� ǥ��
	@RequestMapping(value = "/ReadBoardContent")
	public String ReadBoardContent(Model model, HttpServletRequest request, @RequestParam("bid") int bid) throws Exception {
		model.addAttribute("boardContent", boardService.ReadBoardContent(bid)); // �� ���� ����
		model.addAttribute("ReplyVO", new ReplyVO()); // ��� ǥ��
        model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		return "board/BoardContent";
	}

	// �� ���� 
	@RequestMapping(value = "/deleteBoard")
	public String deleteBoard(@RequestParam("bid") int bid, @RequestParam("uid") String uid, RedirectAttributes redirectAttributes) throws Exception 
	{
	    if(boardService.deleteBoard(bid, uid)!=0)
	    {
	    	boardService.deleteBoard(bid, uid);
	    	redirectAttributes.addFlashAttribute("msg", "�����Ϸ�!");    
	    }
	    
	    else
	    {
	    	redirectAttributes.addFlashAttribute("msg", "������ �����ϴ�");    
	    }
		return "redirect:/board/ShowBoardList";
	}

	// �� ���� ��ũ�� �̵�
	@RequestMapping("/WriteForm")
	public String WriteForm(Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		return "board/WriteForm";
	}

	
	@RequestMapping(value = "/EditForm")
	public String editBoard(@RequestParam("bid") int bid, @RequestParam("uid") String uid, @RequestParam("mode") String mode, BoardVO BoardVO, Model model, RedirectAttributes redirectAttributes , HttpServletRequest request) throws Exception 
	{
		BoardVO ResultVO = new BoardVO();
		ResultVO=boardService.CheckEdit(BoardVO);
		
	   if(ResultVO==null)
	    { 
	    	model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
	    	redirectAttributes.addFlashAttribute("msg", "������ �����ϴ�");    
			return "redirect:/board/ShowBoardList";
	    }
	    
	    else
	    {
	    		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
				model.addAttribute("boardContent", boardService.ReadBoardContent(bid));
				model.addAttribute("mode", mode);
				model.addAttribute("boardVO", new BoardVO());
		    	return "board/EditForm";
	    }
	}


	// �� �ۼ� �� DB�� �ݿ�
	@RequestMapping(value = "/writeBoard", method = RequestMethod.POST)
	public String writeBoard(BoardVO boardVO, Model model, RedirectAttributes rttr, HttpServletRequest request) throws Exception {
		boardService.insertBoard(boardVO);
		return "redirect:/board/ShowBoardList";
	}

	// �� ���� �� DB�� �ݿ�
	@RequestMapping(value = "/editBoard", method = RequestMethod.POST)

	public String editBoard(@ModelAttribute("boardVO") BoardVO boardVO, @RequestParam("mode") String mode, Model model,
			RedirectAttributes rttr, HttpServletRequest request) throws Exception {

		if (mode.equals("edit")) {
			model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
			boardService.updateBoard(boardVO);

		}

		else {
		}

		return "redirect:/board/ShowBoardList";
	}
	
	// ��ۺ���
	@ResponseBody
	@RequestMapping(value = "/ShowReplyList", method = RequestMethod.POST)
	public List<ReplyVO> ShowReplyList(@RequestParam("bid") int bid) throws Exception {
		return boardService.ShowReplyList(bid);
	}

	// ����ۼ� db�� �ݿ�
	@ResponseBody
	@RequestMapping(value = "/WriteReply", method = RequestMethod.POST)
	public Map<String, Object> WriteReply(@RequestBody ReplyVO replyVO) throws Exception {
		Map<String, Object> result = new HashMap<>();

		try {
			boardService.WriteReply(replyVO);
			result.put("status", "OK");

		} catch (Exception e) {

			e.printStackTrace();
			result.put("status", "False");
		}

		return result;
	}

	// ��� ����
	@ResponseBody
	@RequestMapping(value = "/DeleteReply", method = RequestMethod.POST)
	public Map<String, Object> deleteReply(@RequestParam("rid") int rid) throws Exception {
		Map<String, Object> result = new HashMap<>();
		try {

			boardService.deleteReply(rid);
			result.put("status", "OK");

		} catch (Exception e) {

			e.printStackTrace();
			result.put("status", "False");
		}

		return result;
	}

}