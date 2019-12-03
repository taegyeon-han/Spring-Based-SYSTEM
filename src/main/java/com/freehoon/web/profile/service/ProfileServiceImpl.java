
package com.freehoon.web.profile.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.login.service.EncryptionProcess;
import com.freehoon.web.profile.dao.ProfileDao;
import com.freehoon.web.profile.model.ProfileVO;

@Service

public class ProfileServiceImpl implements ProfileService {

	@Inject
	private ProfileDao ProfileDao;

	@Override
	public void insertBasicProfile(ProfileVO ProfileVO) throws Exception 
	{	
		ProfileDao.insertBasicProfile(ProfileVO);
	}
	
	@Override
	public ProfileVO getOtherProfile(String identifier) throws Exception
	{
		 return ProfileDao.getOtherProfile(identifier);
	}
	
	@Override
	public void UpdateProfile(ProfileVO ProfileVO) throws Exception {
		ProfileDao.UpdateProfile(ProfileVO);
	}
	
	@Override
	public void deleteProfile(ProfileVO ProfileVO) throws Exception
	{
		ProfileDao.deleteProfile(ProfileVO);
	}
	

}
