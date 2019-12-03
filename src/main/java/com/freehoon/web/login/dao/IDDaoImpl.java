package com.freehoon.web.login.dao;

import java.util.List; 
import javax.inject.Inject; 
import org.apache.ibatis.session.SqlSession; 
import org.springframework.stereotype.Repository;

import com.freehoon.web.Search;
import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.login.service.EncryptionProcess;
import com.freehoon.web.profile.model.ProfileVO; 

@Repository 
public class IDDaoImpl 
implements IDDao
{
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<IDVO> getUserList(Search search) throws Exception 
	{
		return sqlSession.selectList("com.freehoon.web.user.userMapper.getUserList", search);
	}
	

	@Override
	public int getUserListCnt(Search search) throws Exception 
	{
		return sqlSession.selectOne("com.freehoon.web.user.userMapper.getUserListCnt", search);
	}
	
	@Override
	public LoginVO LoginProcess(LoginVO LoginVO) throws Exception 
	{	
		String encode_password = EncryptionProcess.Encryption(LoginVO.getUid(), LoginVO.getPwd());
		LoginVO.setPwd(encode_password);
				
		return sqlSession.selectOne("com.freehoon.web.user.userMapper.LoginProcess", LoginVO);
	}
	
	@Override
	public ProfileVO IDCheck(ProfileVO ProfileVO) throws Exception 
	{	
		String uid= '4'+ProfileVO.getID_CARD_SERIAL();
		ProfileVO.setID_CARD_SERIAL(uid);
		return sqlSession.selectOne("com.freehoon.web.user.userMapper.IDCheck", ProfileVO);
	}
	
	@Override
	public int insertUser(IDVO IDVO) throws Exception 
	{
		
		String encode_password = EncryptionProcess.Encryption(IDVO.getUid() , IDVO.getPwd());
		IDVO.setPwd(encode_password);
		
	    return sqlSession.insert("com.freehoon.web.user.userMapper.insertUser", IDVO);
	}
	
	@Override
	public int updateUser(IDVO IDVO) throws Exception 
	{
		String encode_password = EncryptionProcess.Encryption(IDVO.getUid() , IDVO.getPwd());
		IDVO.setPwd(encode_password);
		
		return sqlSession.update("com.freehoon.web.user.userMapper.updateUser", IDVO);
	}

}

