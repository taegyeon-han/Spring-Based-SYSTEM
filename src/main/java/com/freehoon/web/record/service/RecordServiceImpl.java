
package com.freehoon.web.record.service;



import java.util.List;




import javax.inject.Inject;




import org.springframework.stereotype.Service;

import com.freehoon.web.Search;
import com.freehoon.web.board.dao.BoardDAO;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.record.model.RecordVO;
import com.freehoon.web.record.dao.*;




@Service

public class RecordServiceImpl implements RecordService{

	@Inject
	private RecordDAO RecordDAO;

	@Override
	public List<RecordVO> ShowRecordList(Object Object) throws Exception
	{
		return RecordDAO.ShowRecordList(Object);
	}
	
}
