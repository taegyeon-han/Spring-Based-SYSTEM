package com.freehoon.web.profile.dao;

import java.util.List;

import javax.inject.Inject; 
import org.apache.ibatis.session.SqlSession; 
import org.springframework.stereotype.Repository;

import com.freehoon.web.Search;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.profile.model.ProfileVO; 

@Repository 
public class ProfileDaoImpl implements  ProfileDao
{
	@Inject
	private SqlSession sqlSession;

	@Override
	public ProfileVO getMyProfile(Object object) throws Exception 
	{
		return sqlSession.selectOne("com.freehoon.web.board.profileMapper.getMyProfile",  object);
	}
	
	@Override
	public ProfileVO SearchID(ProfileVO ProfileVO) throws Exception 
	{
		return sqlSession.selectOne("com.freehoon.web.board.profileMapper.searchID", ProfileVO);

	}
	
	@Override
	public int insertAddtionalProfile(ProfileVO ProfileVO) throws Exception 
	{
		return sqlSession.update("com.freehoon.web.board.profileMapper.insertAddtionalProfile", ProfileVO);
	}
	
	@Override
	public int UpdateUserProfile(ProfileVO ProfileVO) throws Exception
	{
		return sqlSession.update("com.freehoon.web.board.profileMapper.UpdateUserProfile", ProfileVO);
	}
	
	@Override
	public ProfileVO getOtherProfile(String identifier) throws Exception
	{
		return sqlSession.selectOne("com.freehoon.web.board.profileMapper.getOtherProfile", identifier);
	}
	
}

