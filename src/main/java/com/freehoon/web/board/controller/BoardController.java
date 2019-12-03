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
import com.mysql.cj.Session;

@Controller
@RequestMapping(value = "/board")

public class BoardController {

	
	// 화면에 글 리스트 보여주기
	@Inject
	private BoardService boardService;
	@RequestMapping(value = "/ShowBoardList")
	public String ShowBoardList(Model model,  HttpServletRequest request, 
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String keyword) throws Exception {
		// 전체 게시글 개수
		
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

	// 글 내용 보기 및 댓글 표시
	@RequestMapping(value = "/ReadBoardContent")
	public String ReadBoardContent(Model model, HttpServletRequest request, @RequestParam("bid") int bid) throws Exception {
		model.addAttribute("boardContent", boardService.ReadBoardContent(bid)); // 글 내용 보기
		model.addAttribute("ReplyVO", new ReplyVO()); // 댓글 표시
        model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		return "board/BoardContent";
	}

	// 글 삭제
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(Model model, @RequestParam("bid") int bid, HttpServletRequest request) throws Exception {
		boardService.deleteBoard(bid);
	    model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		return "redirect:/board/ShowBoardList";
	}

	// 글 쓰기 링크로 이동
	@RequestMapping("/WriteForm")
	public String WriteForm(Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		return "board/WriteForm";
	}

	// 글 수정 링크로 이동
	@RequestMapping("/EditForm")
	public String EditForm(Model model, HttpServletRequest request) {
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		return "board/EditForm";
	}

	// 글 작성 후 DB에 반영
	@RequestMapping(value = "/writeBoard", method = RequestMethod.POST)
	public String writeBoard(@ModelAttribute("boardVO") BoardVO boardVO, RedirectAttributes rttr, Model model, HttpServletRequest request) throws Exception {
		boardService.insertBoard(boardVO);
		  model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		return "redirect:/board/ShowBoardList";
	}

	// 글 수정 후 DB에 반영
	@RequestMapping(value = "/editBoard", method = RequestMethod.POST)

	public String editBoard(@ModelAttribute("boardVO") BoardVO boardVO, @RequestParam("mode") String mode,
			RedirectAttributes rttr, Model model, HttpServletRequest request) throws Exception {

		if (mode.equals("edit")) {
			
			 model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
			boardService.updateBoard(boardVO);

		}

		else {
		}

		return "redirect:/board/ShowBoardList";
	}

	// 글 수정 모드로 가기위해 데이터 가져오기
	@RequestMapping(value = "/EditForm", method = RequestMethod.GET)
	public String EditForm(@RequestParam("bid") int bid, @RequestParam("mode") String mode, Model model, HttpServletRequest request)
			throws Exception {
		
		model.addAttribute("DBDATA", request.getSession().getAttribute("LoginVO"));
		model.addAttribute("boardContent", boardService.ReadBoardContent(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", new BoardVO());
		return "board/EditForm";
	}

	// 댓글보기
	@ResponseBody
	@RequestMapping(value = "/ShowReplyList", method = RequestMethod.POST)
	public List<ReplyVO> ShowReplyList(@RequestParam("bid") int bid) throws Exception {
		return boardService.ShowReplyList(bid);
	}

	// 댓글작성 db에 반영
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

	// 댓글 삭제
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