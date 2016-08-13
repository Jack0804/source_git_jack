package org.sbs.persistence;

import java.util.List;

import org.sbs.domain.BoardVO;
import org.sbs.domain.CommentVO;

public interface CommentDAO {

	
	public List<CommentVO> read	(int bno);
	public void create		 	(CommentVO vo);
	public void delete		 	(CommentVO vo);
	public void update		 	(CommentVO vo);
	
}
