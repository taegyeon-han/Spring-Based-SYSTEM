package com.freehoon.web.record.dao;



import java.util.List;

import javax.servlet.http.HttpSession;

import com.freehoon.web.profile.model.ProfileVO;
import com.freehoon.web.record.model.RecordVO;


public interface RecordDAO {




	public List<RecordVO> ShowRecordList(String identifier) throws Exception;
	public int insertRecord(RecordVO RecordVO) throws Exception;
	public int insertFirstRecord(RecordVO RecordVO) throws Exception;
	public RecordVO ShowEditRecord(int bid) throws Exception;
	public int updateRecord(RecordVO RecordVO) throws Exception;
	public int deleteRecord(int bid) throws Exception;

	public int insert_Name_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception;
	public int insert_Department_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception;
	public int insert_Position_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception;
	public int insert_Demote_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception;
	public int insert_Promotion_Changed(ProfileVO ProfileVO, HttpSession session) throws Exception;

	public int insert_Status_off(ProfileVO ProfileVO) throws Exception;
	public int insert_Status_on(ProfileVO ProfileVO) throws Exception;
	

}
