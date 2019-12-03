package com.freehoon.web.board.dao;

import java.util.List;
import java.util.Map;

import com.freehoon.web.Search;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;

public interface BoardDAO {

	public List<BoardVO> ShowBoardList(Search search) throws Exception;

	public BoardVO ReadBoardContent(int bid) throws Exception;

	public int insertBoard(BoardVO boardVO) throws Exception;

	public int updateBoard(BoardVO boardVO) throws Exception;

	public int deleteBoard(int bid, String uid) throws Exception;

	public BoardVO CheckEdit(BoardVO  BoardVO) throws Exception;

	public int updateViewCnt(int bid) throws Exception;

	public int getBoardListCnt(Search search) throws Exception; // 총 게시글 개수 확인

	// 댓글 리스트
	public List<ReplyVO> ShowReplyList(int bid) throws Exception;

	public int WriteReply(ReplyVO replyVO) throws Exception;

	public int updateReply(ReplyVO replyVO) throws Exception;

	public int deleteReply(int rid) throws Exception;
}
