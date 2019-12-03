package com.freehoon.web.profile.dao;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.freehoon.web.login.service.EncryptionProcess;
import com.freehoon.web.profile.model.ProfileVO;
import com.freehoon.web.record.model.RecordVO;

@Repository
public class ProfileDaoImpl implements ProfileDao {
	@Inject
	private SqlSession sqlSession;

	@Override
	public int insertBasicProfile(ProfileVO ProfileVO) throws Exception
	{	
		RecordVO RecordVO = new RecordVO();

		String temp_status="����";
		String encoded_ident = EncryptionProcess.Encryption2(ProfileVO.getName(), ProfileVO.getID_CARD_SERIAL());	
		
		ProfileVO.setIdentifier(encoded_ident);
		ProfileVO.setSTATUS(temp_status);
		
		String identifier_temp=ProfileVO.getIdentifier();
		String content_temp=ProfileVO.getName()+"���� "+ProfileVO.getWOR_KDATE()+"�� "+ProfileVO.getLEVEL()+"���� �ӿ�Ǿ����ϴ�.";
		
		RecordVO.setIdentifier(identifier_temp);
		RecordVO.setContent(content_temp);
		
		 sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);
		 
		String identifier_temp2=ProfileVO.getIdentifier();
		String content_temp2=ProfileVO.getName()+"���� "+ProfileVO.getDEPARTMENT()+"��  "+ProfileVO.getPOSITION()+"���� �߷ɹ޾ҽ��ϴ�.";
			
		RecordVO.setIdentifier(identifier_temp2);
		RecordVO.setContent(content_temp2);
			
		sqlSession.insert("com.freehoon.web.board.RecordMapper.insertRecord", RecordVO);

		
		
		 return sqlSession.insert("com.freehoon.web.board.profileMapper.insertBasicProfile", ProfileVO);
	}

	@Override
	public ProfileVO getOtherProfile(String identifier) throws Exception {
		return sqlSession.selectOne("com.freehoon.web.board.profileMapper.getOtherProfile", identifier);
	}

	@Override
	public int UpdateProfile(ProfileVO ProfileVO) throws Exception {
		
		sqlSession.update("com.freehoon.web.board.profileMapper.UpdateUserProfile", ProfileVO);
		return sqlSession.update("com.freehoon.web.board.profileMapper.UpdateProfile", ProfileVO);
	}
	
	@Override
	public int deleteProfile(ProfileVO ProfileVO) throws Exception 
	{
		sqlSession.insert("com.freehoon.web.board.profileMapper.deletingAllRecord", ProfileVO);
		return sqlSession.insert("com.freehoon.web.board.profileMapper.deleteProfile", ProfileVO);

	}


}
