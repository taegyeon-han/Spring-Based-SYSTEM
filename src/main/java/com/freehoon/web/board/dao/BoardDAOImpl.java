package com.freehoon.web.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.freehoon.web.Search;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;

@Repository

public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;

	@Override

	public List<BoardVO> ShowBoardList(Search search) throws Exception {
		return sqlSession.selectList("com.freehoon.web.board.boardMapper.getBoardList", search);

	}

	@Override

	public BoardVO ReadBoardContent(int bid) throws Exception {

		return sqlSession.selectOne("com.freehoon.web.board.boardMapper.getBoardContent", bid);

	}

	@Override

	public int insertBoard(BoardVO boardVO) throws Exception {

		return sqlSession.insert("com.freehoon.web.board.boardMapper.insertBoard", boardVO);

	}

	@Override

	public int updateBoard(BoardVO boardVO) throws Exception {

		return sqlSession.update("com.freehoon.web.board.boardMapper.updateBoard", boardVO);

	}

	@Override
	public int deleteBoard(int bid, String uid) throws Exception 
	{

		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("bid", bid);
		map.put("uid", uid);
		
		return sqlSession.insert("com.freehoon.web.board.boardMapper.deleteBoard", map);

	}
	
	@Override
	public BoardVO CheckEdit(BoardVO BoardVO) throws Exception 
	{	
		
		
		return  sqlSession.selectOne("com.freehoon.web.board.boardMapper.CheckEdit", BoardVO);

	}

	@Override

	public int updateViewCnt(int bid) throws Exception {

		return sqlSession.update("com.freehoon.web.board.boardMapper.updateViewCnt", bid);

	}

	// 총 게시글 개수 확인
	

	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return sqlSession.selectOne("com.freehoon.web.board.boardMapper.getBoardListCnt");
	}

	// 댓글 리스트

	@Override
	public List<ReplyVO> ShowReplyList(int bid) throws Exception {
		return sqlSession.selectList("com.freehoon.web.board.ReplyMapper.ShowReplyList", bid);

	}

	@Override
	public int WriteReply(ReplyVO replyVO) throws Exception {
		return sqlSession.insert("com.freehoon.web.board.ReplyMapper.WriteReply", replyVO);

	}

	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		return sqlSession.update("com.freehoon.web.board.ReplyMapper.updateReply", replyVO);

	}

	@Override
	public int deleteReply(int rid) throws Exception {
		return sqlSession.delete("com.freehoon.web.board.ReplyMapper.deleteReply", rid);

	}
}
