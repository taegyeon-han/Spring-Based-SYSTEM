
package com.freehoon.web.record.service;



import java.util.List;




import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.freehoon.web.Search;
import com.freehoon.web.board.dao.BoardDAO;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.profile.model.ProfileVO;
import com.freehoon.web.record.model.RecordVO;
import com.freehoon.web.record.dao.*;




@Service

public class RecordServiceImpl implements RecordService{

	@Inject
	private RecordDAO RecordDAO;

	@Override
	public List<RecordVO> ShowRecordList(String identifier) throws Exception
	{
		return RecordDAO.ShowRecordList(identifier);
	}
	
	@Override
	public void insertRecord(RecordVO RecordVO ) throws Exception
	{
		RecordDAO.insertRecord(RecordVO);
	}
	
	@Override
	public RecordVO ShowEditRecord(int bid) throws Exception
	{
		return RecordDAO.ShowEditRecord(bid);
	}
	
	@Override
	public void updateRecord(RecordVO RecordVO) throws Exception
	{
		RecordDAO.updateRecord(RecordVO);
	}
	
	@Override
	public void deleteRecord(int bid) throws Exception
	{
		RecordDAO.deleteRecord(bid);
	}
	
	
	@Override
	public void insert_Name_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception
	{
		RecordDAO.insert_Name_Changed(ProfileVO, session);
	}
	
	@Override
	public void insert_Department_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception
	{
		RecordDAO.insert_Department_Changed(ProfileVO, session);
	}
	
	@Override
	public void insert_Position_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception
	{
		RecordDAO.insert_Position_Changed(ProfileVO, session);
	}
	

	@Override
	public void insert_Demote_Changed(ProfileVO ProfileVO, HttpSession session)throws Exception
	{
		RecordDAO. insert_Demote_Changed(ProfileVO, session);
	}
	
	@Override
	public void insert_Promotion_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception
	{
		RecordDAO.insert_Promotion_Changed(ProfileVO, session);
	}
	
	@Override
	public void insert_Status_off(ProfileVO ProfileVO) throws Exception
	{
		RecordDAO.insert_Status_off(ProfileVO);
	}
	
	@Override
	public void insert_Status_on(ProfileVO ProfileVO) throws Exception
	{
		RecordDAO.insert_Status_on(ProfileVO);
	}
	
}
