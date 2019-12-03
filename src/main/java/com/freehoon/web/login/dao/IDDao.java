package com.freehoon.web.login.dao;

import java.util.List;

import com.freehoon.web.Search;
import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.login.model.RestPassWordVO; 

public interface IDDao 

{
	public List<IDVO> getUserList(Search search) throws Exception;
	public List<IDVO> getIDUserList() throws Exception;
	
	public int getUserListCnt(Search search) throws Exception;
	
	public int insertUser(IDVO IDVO) throws Exception;
	public int updateUser(IDVO IDVO) throws Exception;
	public int deleteUser(String uid) throws Exception;
	
	public LoginVO LoginProcess(LoginVO LoginVO) throws Exception; 
	public RestPassWordVO ResetPassWord(RestPassWordVO  RestPassWordVO) throws Exception;
	public int ResetingPassWord(RestPassWordVO ResetPassWordVO) throws Exception;
}
