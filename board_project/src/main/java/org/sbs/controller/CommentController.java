package org.sbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.sbs.domain.BoardVO;
import org.sbs.domain.CommentVO;
import org.sbs.domain.PageMaker;
import org.sbs.service.BoardService;
import org.sbs.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController // CommentController를 REST방식으로 설정.
@RequestMapping("/comment")
public class CommentController {

	@Inject
	CommentService service;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping(value = "/list/{bno}", method = RequestMethod.GET)
	public List<CommentVO> list(@PathVariable int bno) {

		List<CommentVO> list = service.getRead(bno);

		return list;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@RequestBody CommentVO vo) {

		service.create(vo);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestBody CommentVO vo) {

		service.delete(vo);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestBody CommentVO vo) {

		service.update(vo);
	}
}
