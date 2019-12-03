
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
import com.freehoon.web.login.model.RestPassWordVO; 

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
	
	public List<IDVO> getIDUserList() throws Exception
	{
		return IDDao.getIDUserList();
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
	public void insertUser(IDVO IDVO) throws Exception 
	{
		IDDao.insertUser(IDVO);
	}
	
	@Override
	public void updateUser(IDVO IDVO) throws Exception 
	{
		IDDao.updateUser(IDVO);
	}
	
	@Override
	public void ResetingPassWord(RestPassWordVO ResetPassWordVO) throws Exception
	{
		
		IDDao.ResetingPassWord(ResetPassWordVO);
	}
	
	@Override
	public void deleteUser(String uid) throws Exception 
	{
		IDDao.deleteUser(uid);
	} 
	
	@Override
	public RestPassWordVO ResetPassWord(RestPassWordVO  RestPassWordVO) throws Exception
	{
		return IDDao.ResetPassWord(RestPassWordVO);
	}
	
}

