package org.sbs.service;

import java.util.List;

import javax.inject.Inject;

import org.sbs.domain.CommentVO;
import org.sbs.persistence.BoardDAO;
import org.sbs.persistence.CommentDAO;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Inject
	private CommentDAO dao;

	@Inject
	private BoardDAO boardDao;

	@Override
	public List<CommentVO> getRead(int bno) {

		return dao.read(bno);
	}

	@Override
	public void create(CommentVO vo) {

		dao.create(vo);
		boardDao.commentCount(vo.getBno());
	}

	@Override
	public void delete(CommentVO vo) {

		dao.delete(vo);
		boardDao.commentCount(vo.getBno());
	}

	@Override
	public void update(CommentVO vo) {

		dao.update(vo);

	}
}
