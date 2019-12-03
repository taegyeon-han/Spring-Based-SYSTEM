package com.freehoon.web.record.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;


import com.freehoon.web.record.model.RecordVO;

@Repository

public class RecordDAOImpl implements RecordDAO {

	@Inject
	private SqlSession sqlSession;

	@Override

	public List<RecordVO> ShowRecordList(Object Object) throws Exception {
		return sqlSession.selectList("com.freehoon.web.board.RecordMapper.getRecord", Object);

	}



}
