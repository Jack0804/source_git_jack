package org.sbs.service;

import java.util.List;

import javax.inject.Inject;

import org.sbs.domain.BoardVO;
import org.sbs.persistence.BoardDAO;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	public void insert(BoardVO vo) {
		dao.create(vo);
	}

	@Override
	public List<BoardVO> getRead(int page) {
		return dao.read(page);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(int bno) {
		dao.delete(bno);
	}

	@Override
	public int count() {

		return dao.totalCount();
	}

	@Override
	public BoardVO view(int bno) {

		hits(bno);

		return dao.view(bno);
	}

	@Override
	public BoardVO hits(int bno) {

		return dao.hits(bno);
	}
}
