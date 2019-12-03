package com.freehoon.web.profile.dao;

import com.freehoon.web.profile.model.ProfileVO;

public interface ProfileDao 

{
	public int insertBasicProfile(ProfileVO ProfileVO) throws Exception;
	public ProfileVO getOtherProfile(String identifier) throws Exception;
	public int UpdateProfile(ProfileVO ProfileVO) throws Exception;
	public int deleteProfile(ProfileVO ProfileVO) throws Exception;
}
