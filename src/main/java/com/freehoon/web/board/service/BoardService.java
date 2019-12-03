package com.freehoon.web.board.service;




import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.freehoon.web.Search;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;




public interface BoardService {


	public List<BoardVO> ShowBoardList(Search search) throws Exception;
	public void insertBoard(BoardVO boardVO) throws Exception;
	public BoardVO ReadBoardContent(int bid) throws Exception;
	public void updateBoard(BoardVO boardVO) throws Exception;
	public int getBoardListCnt(Search search) throws Exception; 	//총 게시글 개수 확인
	public int deleteBoard(int bid, String uid) throws Exception;
	public BoardVO CheckEdit(BoardVO BoardVO) throws Exception;
	
	public List<ReplyVO> ShowReplyList(int bid) throws Exception;
	public int WriteReply(ReplyVO replyVO) throws Exception;
	public int updateReply(ReplyVO replyVO) throws Exception;
	public int deleteReply(int rid) throws Exception;


}

