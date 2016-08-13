package org.sbs.service;

import java.util.List;

import org.sbs.domain.BoardVO;
import org.sbs.domain.CommentVO;

public interface CommentService {

	public List<CommentVO> getRead(int bno);
	public void create(CommentVO vo);
	public void delete(CommentVO vo);
	public void update(CommentVO vo);
	
}
