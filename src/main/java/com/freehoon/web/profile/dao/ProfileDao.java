package com.freehoon.web.profile.dao;

import java.util.List;

import com.freehoon.web.Search;
import com.freehoon.web.profile.model.ProfileVO;

public interface ProfileDao 

{
	public ProfileVO SearchID(ProfileVO ProfileVO) throws Exception;
	public int insertAddtionalProfile(ProfileVO ProfileVO) throws Exception;
	public ProfileVO getMyProfile(Object object) throws Exception;
	public int UpdateUserProfile(ProfileVO ProfileVO) throws Exception;
	public ProfileVO getOtherProfile(String identifier) throws Exception;
	
}
