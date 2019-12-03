package com.freehoon.web.login.dao;

import java.util.List;

import com.freehoon.web.Search;
import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.profile.model.ProfileVO; 

public interface IDDao 

{
	public List<IDVO> getUserList(Search search) throws Exception;
	public int getUserListCnt(Search search) throws Exception;
	public int insertUser(IDVO IDVO) throws Exception;
	public int updateUser(IDVO IDVO) throws Exception;
	public LoginVO LoginProcess(LoginVO LoginVO) throws Exception; 
	public ProfileVO IDCheck(ProfileVO ProfileVO) throws Exception; 
}
