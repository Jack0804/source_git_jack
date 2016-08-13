package org.sbs.persistence;

import java.util.List;
import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.sbs.domain.BoardVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardVO> read(int page) {

		System.out.println("(BoardDAOImpl) Start Read");
		return sqlSession.selectList("org.sbs.persistence.boardMapper.read", (page - 1) * 10);
	}

	@Override
	public void create(BoardVO vo) {

		sqlSession.insert("org.sbs.persistence.boardMapper.create", vo);
	}

	@Override
	public void delete(int bno) {
		sqlSession.update("org.sbs.persistence.boardMapper.delete", bno);
	}

	@Override
	public void update(BoardVO vo) {
		sqlSession.update("org.sbs.persistence.boardMapper.update", vo);
	}

	@Override
	public int totalCount() {

		return sqlSession.selectOne("org.sbs.persistence.boardMapper.count");
	}

	@Override
	public BoardVO view(int bno) {

		return sqlSession.selectOne("org.sbs.persistence.boardMapper.view", bno);
	}

	@Override
	public BoardVO hits(int bno) {

		return sqlSession.selectOne("org.sbs.persistence.boardMapper.hits", bno);
	}

	@Override
	public void commentCount(int bno) {
		sqlSession.update("org.sbs.persistence.boardMapper.comment", bno);
	}
}
