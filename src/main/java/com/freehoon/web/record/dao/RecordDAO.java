package com.freehoon.web.record.dao;



import java.util.List;
import com.freehoon.web.Search;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.record.model.RecordVO;


public interface RecordDAO {




	public List<RecordVO> ShowRecordList(Object Object) throws Exception;



}
