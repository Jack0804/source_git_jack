package org.sbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.sbs.domain.BoardVO;
import org.sbs.domain.CommentVO;
import org.sbs.domain.PageMaker;
import org.sbs.service.BoardService;
import org.sbs.service.BoardServiceImpl;
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
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("/board")			// /board 주소를 입력하여 시작.
public class BoardController {

	@Inject
	BoardService service;			// org.sbs.service에서 boardService를 Inject

	@Inject
	CommentService commentService;	// org.sbs.service에서 CommentService를 Inject

	// logger처리
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	// URL로 입력되는 모든 값은 Parameter값으로 들어온다.
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(PageMaker pagemaker, Model model) {

		logger.info("START LIST");				// 로그

		int count = 0;	// count변수 선언.

		pagemaker.setPage(pagemaker.getPage());	// 페이지메이커에서 page를 set하기 위하여 먼저 page를 얻어온다.
		
		count = service.count(); 	// 레코드 총 갯수 구함
		pagemaker.setCount(count); 	// 페이지 계산

		// service.getRead -> Select list
		// 현재 얻어온 페이지를 Query문에 전송. 리턴 값은 List에 담는다.(자료형은 BoardVO)
		List<BoardVO> list = service.getRead(pagemaker.getPage());

		// 아래 문장은 list.jsp에서 key값으로 사용한다.
		model.addAttribute("result", 	list);		 // 파라미터 Model를 사용하여 KEY - "result" 	/ value - "list"사용
		model.addAttribute("pageMaker", pagemaker);  // 파라미터 Model를 사용하여 KEY - "pageMaker" / value - "pagemaer"사용

		return "/board/list";	// /WEB-INF/board/list.jsp 실행.
	}

	
	// 글 클릭시, view로 이동.
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void view(int bno, Model model) {

		// 해당 글 클릭의 BNO값을 Query문 파라미터 값으로 전달
		// 리턴값은 BoardVO의 변수 값으로 받는다.
		BoardVO vo = service.view(bno);		
		model.addAttribute("view", vo);
	}

	
	// 글 등록 버튼 누를 시, 
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {

		return "/board/register";
	}

	
	// 글 등록 -> 확인버튼 누를 시,
	@RequestMapping(value = "/registerresult", method = RequestMethod.POST)
	public String registerResult(BoardVO vo) {

		logger.info("vo.tostring = " + vo.toString());

		service.insert(vo);

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		logger.info("START LOGIN");

		return "/board/login";
	}

	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modify(BoardVO vo, Model model) {

		logger.info("vo.tostring = " + vo.toString());

		model.addAttribute("modify", service.view(vo.getBno()));
	}

	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVO vo) {

		logger.info("vo.tostring = " + vo.toString());

		service.update(vo);

		return "redirect:/board/view?bno=" + vo.getBno();
	}

	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(BoardVO vo) {

		logger.info("vo.tostring = " + vo.toString());

		service.delete(vo.getBno());

		return "redirect:/board/list";
	}
}
