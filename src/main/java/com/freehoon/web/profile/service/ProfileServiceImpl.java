
package com.freehoon.web.profile.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.freehoon.web.Search;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.profile.dao.ProfileDao;
import com.freehoon.web.profile.model.ProfileVO;

@Service

public class ProfileServiceImpl implements ProfileService
{

	@Inject
	private ProfileDao ProfileDao;
	
	//공무원증 조회
	@Override
	public ProfileVO SearchID(ProfileVO ProfileVO) throws Exception {
		return ProfileDao.SearchID(ProfileVO);
	}
	
	//회원 가입할때 추가 정보 넣기
	@Override
	public void insertAddtionalProfile(ProfileVO ProfileVO) throws Exception 
	{
		ProfileDao.insertAddtionalProfile(ProfileVO);
	}
	
	//내정보 가지고 오기
	@Override
	public ProfileVO getMyProfile(Object object) throws Exception
	{
		return ProfileDao.getMyProfile(object);
	}
	
	@Override
	public int UpdateUserProfile(ProfileVO ProfileVO) throws Exception
	{
		return ProfileDao.UpdateUserProfile(ProfileVO);
	}
	
	@Override
	public ProfileVO getOtherProfile(String identifier) throws Exception
	{
		 return ProfileDao.getOtherProfile(identifier);
	}
	

}
