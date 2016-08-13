package org.sbs.controller;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sbs.domain.BoardVO;
import org.sbs.domain.CommentVO;
import org.sbs.persistence.BoardDAO;
import org.sbs.persistence.CommentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
locations ={"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class test {
	
	@Autowired
	public DataSource ds;
	
	@Inject
	public BoardDAO dao;
	
	@Inject
	public CommentDAO commentDao;
	
	private static Logger logger = LoggerFactory.getLogger(test.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		
		Connection con = ds.getConnection();
		
		logger.info("Connection Test = "+con); // 연결TEST
		
		con.close();
	}
	
	
	@Test
	public void read() throws Exception {
		
		List<BoardVO> list = new ArrayList<>();

		list = dao.read(1);

		for (BoardVO vo : list) {

			logger.info("" + vo.toString());
		}
	}
	
	@Test
	public void insert() throws Exception {
		
		BoardVO vo = new BoardVO();
		
		vo.setWriter("남재건");
		vo.setContents("내용입니다");
		vo.setTitle("제목입니다");
		vo.setHits(1);
		vo.setComments(3);
		
		dao.create(vo);
	}
	
	@Test
	public void delete() throws Exception {
		
		dao.delete(6);
	}
	
	@Test
	public void update() throws Exception {
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(7);
		vo.setWriter  ("Update테스트입니다.");
		vo.setContents("Update테스트_내용입니다");
		vo.setTitle	  ("Update테스트_제목입니다");
		vo.setHits(4);
		vo.setComments(5);

		dao.update(vo);
	}
	
	@Test
	public void count() throws Exception {
		
		logger.info( "START COUNT" );
		dao.totalCount();
	}
	
	@Test
	public void view() throws Exception {
		
		logger.info( "START view" );
		
		BoardVO vo = new BoardVO();

		vo = dao.view(1);
	
		logger.info("" + vo.toString());
		
	}
	
	@Test
	public void comment() throws Exception {
		
		logger.info( "comment start" );
		
		List<CommentVO> list = new ArrayList<>();
		list = commentDao.read(1);
	
		for (CommentVO vo : list) {
			logger.info("" + vo.toString());
		}
	}
	
	@Test
	public void commentInsert() throws Exception {
		
		logger.info( "commentInsert start" );
		
		CommentVO vo = new CommentVO();
		
		vo.setBno(231);
		vo.setContents("내용입니다");
		
		commentDao.create(vo);
	}
	
	@Test
	public void commentUpdate() throws Exception {
		
		logger.info( "commentUpdate start" );
		
		CommentVO vo = new CommentVO();
		
		vo.setCno(1);
		vo.setContents("테스트 내용입니다");
		
		commentDao.update(vo);
	}
	
	
	@Test
	public void commentTest() throws Exception {
		
		logger.info( "commentUpdate start" );
		
		dao.commentCount(231);
		
	}
}
