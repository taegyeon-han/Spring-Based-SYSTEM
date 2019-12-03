
package com.freehoon.web.login.service;

import java.util.List; 
import javax.inject.Inject; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.stereotype.Service;

import com.freehoon.web.Search;
import com.freehoon.web.login.dao.IDDao;
import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.profile.model.ProfileVO; 

@Service
public class IDServiceImpl implements IDService
{
	private static final Logger logger = LoggerFactory.getLogger(IDServiceImpl.class);
	@Inject
	private IDDao IDDao;
	
	@Override
	public List<IDVO> getUserList(Search search) throws Exception
	{
		return IDDao.getUserList(search);
	}
	
	@Override
	public int getUserListCnt(Search search) throws Exception {
		return IDDao.getUserListCnt(search);

	}
	
	
	@Override
	public LoginVO LoginProcess(LoginVO LoginVO) throws Exception 
	{
		return IDDao.LoginProcess(LoginVO);
	}
	
	@Override
	public ProfileVO IDCheck(ProfileVO ProfileVO) throws Exception 
	{
		return IDDao.IDCheck(ProfileVO);
	}
	
	@Override
	public void insertUser(IDVO IDVO) throws Exception 
	{
		IDDao.insertUser(IDVO);
	}
	
	@Override
	public void updateUser(IDVO IDVO) throws Exception 
	{
		IDDao.updateUser(IDVO);
	}

}

