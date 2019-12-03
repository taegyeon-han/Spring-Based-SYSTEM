package com.freehoon.web.record.service;




import java.util.List;

import javax.servlet.http.HttpSession;

import com.freehoon.web.Search;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.profile.model.ProfileVO;
import com.freehoon.web.record.model.RecordVO;




public interface RecordService {

	public List<RecordVO> ShowRecordList(String identifier) throws Exception;
	public void insertRecord(RecordVO RecordVO) throws Exception;
	public void updateRecord(RecordVO RecordVO) throws Exception;
	public RecordVO ShowEditRecord(int bid) throws Exception;
	public void deleteRecord(int bid) throws Exception;
	
	public void insert_Name_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception;
	public void insert_Department_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception;
	public void insert_Position_Changed(ProfileVO ProfileVO, HttpSession session)throws Exception;
	public void insert_Demote_Changed(ProfileVO ProfileVO, HttpSession session)throws Exception; 
	public void insert_Promotion_Changed(ProfileVO ProfileVO, HttpSession session)throws Exception; 
		
	public void insert_Status_off(ProfileVO ProfileVO) throws Exception; 
	public void insert_Status_on(ProfileVO ProfileVO) throws Exception; 

	
	
}

