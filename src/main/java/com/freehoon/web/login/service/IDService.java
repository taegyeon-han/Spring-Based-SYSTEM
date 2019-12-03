package com.freehoon.web.login.service;


import java.util.List;

import com.freehoon.web.Search;
import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.profile.model.ProfileVO;


public interface IDService {


	public List<IDVO> getUserList(Search search) throws Exception;
	public int getUserListCnt(Search search) throws Exception;
	public LoginVO LoginProcess(LoginVO LoginVO) throws Exception;
	public ProfileVO IDCheck(ProfileVO ProfileVO) throws Exception;
	public void insertUser(IDVO IDVO) throws Exception;
	public void updateUser(IDVO IDVO) throws Exception;

}

