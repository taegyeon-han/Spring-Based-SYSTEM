package com.freehoon.web.profile.service;



import java.util.List;

import com.freehoon.web.Search;
import com.freehoon.web.profile.model.ProfileVO;

public interface ProfileService 
{

	public ProfileVO SearchID(ProfileVO ProfileVO) throws Exception;
	public void insertAddtionalProfile(ProfileVO ProfileVO) throws Exception;
	public ProfileVO getMyProfile(Object object) throws Exception;
	public int UpdateUserProfile(ProfileVO ProfileVO) throws Exception;
	public ProfileVO getOtherProfile(String identifier) throws Exception;
	
}

