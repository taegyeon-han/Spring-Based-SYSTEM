package com.freehoon.web.record.dao;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.freehoon.web.profile.model.ProfileVO;
import com.freehoon.web.record.model.RecordVO;

@Repository

public class RecordDAOImpl implements RecordDAO {

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<RecordVO> ShowRecordList(String identifier) throws Exception {
		return sqlSession.selectList("com.freehoon.web.board.RecordMapper.getRecord", identifier);

	}


	@Override
	public int insertRecord(RecordVO RecordVO) throws Exception {
		
		return sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);

	}
	
	@Override

	public int insertFirstRecord(RecordVO RecordVO) throws Exception 
	{
		return sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);

	}
	
	@Override
	public RecordVO ShowEditRecord(int bid) throws Exception
	{
		return sqlSession.selectOne("com.freehoon.web.board.RecordMapper.getEditRecord", bid);
	}
	
	
	@Override
	public int updateRecord(RecordVO RecordVO) throws Exception {
		return sqlSession.update("com.freehoon.web.board.RecordMapper.UpdateRecord", RecordVO);

	}

	@Override

	public int deleteRecord(int bid) throws Exception {

		return sqlSession.insert("com.freehoon.web.board.RecordMapper.deleteRecord", bid);

	}
	

	// ���⼭�� ���� ���� ���� �� �λ��Ͽ� �ݿ� �Ǵ� �κ��� 
	
	@Override
	public int insert_Name_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception {
		
		RecordVO RecordVO = new RecordVO();
		ProfileVO old_data = (ProfileVO)session.getAttribute("identifier");
		
		String old_name= old_data.getName();
		String new_name = ProfileVO.getName();
		
		String identifier_temp = old_data.getIdentifier();
		String content_temp = old_name+"���� "+new_name+"���� ����Ǿ����ϴ�.";
				
		RecordVO.setIdentifier(identifier_temp);
		RecordVO.setContent(content_temp);
		
		return sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);

	}
	
	@Override
	public int insert_Department_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception 
	{
		
		RecordVO RecordVO = new RecordVO();
		ProfileVO old_data = (ProfileVO)session.getAttribute("identifier");
		
		String new_name = ProfileVO.getName();
		
		String old_dep= old_data.getDEPARTMENT();
		String new_dep = ProfileVO.getDEPARTMENT();
		
		String identifier_temp = old_data.getIdentifier();
		String content_temp = new_name+"���� "+old_dep+"���� "+new_dep+"�� �μ� �̵��Ͽ����ϴ�.";
				
		RecordVO.setIdentifier(identifier_temp);
		RecordVO.setContent(content_temp);
		
		return sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);

	}
	@Override
	public int insert_Position_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception {
		
		RecordVO RecordVO = new RecordVO();
		ProfileVO old_data = (ProfileVO)session.getAttribute("identifier");
		
		String new_name = ProfileVO.getName();
		
		String old_pos= old_data.getPOSITION();
		String new_pos = ProfileVO.getPOSITION();
		
		String identifier_temp = old_data.getIdentifier();
		String content_temp = new_name+"���� "+old_pos+"���� "+new_pos+"���� ��å�� ���� �Ǿ����ϴ�." ;
				
		RecordVO.setIdentifier(identifier_temp);
		RecordVO.setContent(content_temp);
		
		return sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);

	}
	
	@Override
	public int insert_Demote_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception {
		
		RecordVO RecordVO = new RecordVO();
		ProfileVO old_data = (ProfileVO)session.getAttribute("identifier");
		
		String new_name = ProfileVO.getName();
		
		String old_level= old_data.getLEVEL();
		String new_level= ProfileVO.getLEVEL();
		
		String identifier_temp = old_data.getIdentifier();
		String content_temp = new_name+"���� "+old_level+"���� "+new_level+"�� ���� �Ͽ����ϴ�.";
				
		RecordVO.setIdentifier(identifier_temp);
		RecordVO.setContent(content_temp);
		
		return sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);

	}
	
	@Override
	public int insert_Promotion_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception {
		
		RecordVO RecordVO = new RecordVO();
		ProfileVO old_data = (ProfileVO)session.getAttribute("identifier");
		
		String new_name = ProfileVO.getName();
		
		String old_level= old_data.getLEVEL();
		String new_level= ProfileVO.getLEVEL();
		
		String identifier_temp = old_data.getIdentifier();
		String content_temp = new_name+"���� "+old_level+"���� "+new_level+"�� ���� �Ͽ����ϴ�.";
				
		RecordVO.setIdentifier(identifier_temp);
		RecordVO.setContent(content_temp);
		
		return sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);

	}
	
	@Override
	public int insert_Status_off(ProfileVO ProfileVO) throws Exception
	{
		RecordVO RecordVO = new RecordVO();
	
		String content_temp = ProfileVO.getName()+"���� ���� �Ͽ����ϴ�.";
		RecordVO.setContent(content_temp);
		RecordVO.setIdentifier(ProfileVO.getIdentifier());
		
		sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);
		
		content_temp = "���� ���� :"+ProfileVO.getREASON();
		RecordVO.setContent(content_temp);
		RecordVO.setIdentifier(ProfileVO.getIdentifier());
		
		return sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);
	}
	
	@Override
	public int insert_Status_on(ProfileVO ProfileVO) throws Exception
	{
		RecordVO RecordVO = new RecordVO();
		
		String content_temp = ProfileVO.getName()+"���� ���� �Ͽ����ϴ�.";
		RecordVO.setContent(content_temp);
		ProfileVO.setREASON(null);
		RecordVO.setIdentifier(ProfileVO.getIdentifier());

		
		return sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);
	}
	
	
	

}
