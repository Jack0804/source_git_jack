package org.sbs.persistence;

import java.util.List;

import org.sbs.domain.BoardVO;

public interface BoardDAO {

	// CRUD 관련
	public void create(BoardVO vo);

	public List<BoardVO> read(int page);

	public void update(BoardVO vo);

	public void delete(int bno);

	// Page 관련
	public int totalCount();

	// View 관련
	public BoardVO view(int bno);

	// hits(조회수) 관련
	public BoardVO hits(int bno);

	// comment(갯수) 관련
	public void commentCount(int bno);
}
