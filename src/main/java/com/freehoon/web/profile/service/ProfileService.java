package com.freehoon.web.profile.service;

import com.freehoon.web.profile.model.ProfileVO;

public interface ProfileService 
{

	public void insertBasicProfile(ProfileVO ProfileVO) throws Exception;
	public ProfileVO getOtherProfile(String identifier) throws Exception;
	public void UpdateProfile(ProfileVO ProfileVO) throws Exception;
	public void deleteProfile(ProfileVO ProfileVO) throws Exception;

}

