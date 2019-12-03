package com.freehoon.web.login.dao;

import java.util.List; 
import javax.inject.Inject; 
import org.apache.ibatis.session.SqlSession; 
import org.springframework.stereotype.Repository;

import com.freehoon.web.Search;
import com.freehoon.web.login.model.IDVO;
import com.freehoon.web.login.model.LoginVO;
import com.freehoon.web.login.model.RestPassWordVO;
import com.freehoon.web.login.service.EncryptionProcess; 

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
	public List<IDVO> getIDUserList() throws Exception
	{
		return sqlSession.selectList("com.freehoon.web.user.userMapper.getIDList");
	}
	
	@Override
	public RestPassWordVO ResetPassWord( RestPassWordVO  RestPassWordVO) throws Exception
	{
		return sqlSession.selectOne("com.freehoon.web.user.userMapper.ResetPassWord",  RestPassWordVO);
	}
	
	@Override
	public int ResetingPassWord(RestPassWordVO ResetPassWordVO) throws Exception
	{
		String encode_password = EncryptionProcess.Encryption(ResetPassWordVO.getUid(), ResetPassWordVO.getPwd());
		ResetPassWordVO.setPwd(encode_password);
		
		return sqlSession.update("com.freehoon.web.user.userMapper.ResetingPassWord", ResetPassWordVO);
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
	public int insertUser(IDVO IDVO) throws Exception 
	{
			String encode_password = EncryptionProcess.Encryption(IDVO.getUid(), IDVO.getPwd());
			IDVO.setPwd(encode_password);
	        
	        return sqlSession.insert("com.freehoon.web.user.userMapper.insertUser", IDVO);
	}
	
	@Override
	public int updateUser(IDVO IDVO) throws Exception 
	{
		return sqlSession.update("com.freehoon.web.user.userMapper.updateUser", IDVO);
	}
	
	@Override
	public int deleteUser(String uid) throws Exception 
	{
		return sqlSession.delete("com.freehoon.web.user.userMapper.deleteUser", uid);
	} 

}

