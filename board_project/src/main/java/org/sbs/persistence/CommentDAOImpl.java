package org.sbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.sbs.domain.CommentVO;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Inject
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CommentVO> read(int bno) {

		return sqlSession.selectList("org.sbs.persistence.commentMapper.read", bno);
	}

	@Override
	public void create(CommentVO vo) {
		sqlSession.insert("org.sbs.persistence.commentMapper.create", vo);
	}

	@Override
	public void delete(CommentVO vo) {
		sqlSession.delete("org.sbs.persistence.commentMapper.delete", vo);
	}

	@Override
	public void update(CommentVO vo) {

		sqlSession.update("org.sbs.persistence.commentMapper.update", vo);
	}

}
