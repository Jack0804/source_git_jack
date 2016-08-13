package org.sbs.service;

import java.util.List;

import org.sbs.domain.BoardVO;

public interface BoardService {

	// CRUD 관련
	public void insert(BoardVO vo);

	public List<BoardVO> getRead(int page);

	public void update(BoardVO vo);

	public void delete(int bno);

	// Page 관련
	public int count();

	// View 관련
	public BoardVO view(int bno);

	// 조회수(hits) 관련
	public BoardVO hits(int bno);
}
