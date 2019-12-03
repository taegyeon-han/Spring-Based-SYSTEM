
package com.freehoon.web.board.service;



import java.util.List;




import javax.inject.Inject;




import org.springframework.stereotype.Service;

import com.freehoon.web.Search;
import com.freehoon.web.board.dao.BoardDAO;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;




@Service

public class BoardServiceImpl implements BoardService{

	@Inject

	private BoardDAO boardDAO;

	public List<BoardVO> ShowBoardList(Search search) throws Exception {
		return boardDAO.ShowBoardList(search);

	}
	
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}
	
	@Override
	public void deleteBoard(int bid) throws Exception {
		boardDAO.deleteBoard(bid);
	}
	
	public BoardVO ReadBoardContent(int bid) throws Exception{

		boardDAO.updateViewCnt(bid);
		return boardDAO.ReadBoardContent(bid);
	}
	
	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return boardDAO.getBoardListCnt(search);

	}
	
	// ´ñ±Û ¸®½ºÆ®

		@Override
		public List<ReplyVO> ShowReplyList(int bid) throws Exception {
			return boardDAO.ShowReplyList(bid);
		}

		@Override
		public int WriteReply(ReplyVO replyVO) throws Exception {
			return boardDAO.WriteReply(replyVO);

		}

		@Override

		public int updateReply(ReplyVO replyVO) throws Exception {

			return boardDAO.updateReply(replyVO);

		}

		@Override

		public int deleteReply(int rid) throws Exception {

			return boardDAO.deleteReply(rid);
		}
}
