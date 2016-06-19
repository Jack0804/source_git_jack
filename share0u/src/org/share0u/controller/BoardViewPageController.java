package org.share0u.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.share0u.dao.Share0uDAO;
import org.share0u.domain.RecordVO;

/**
 * Servlet implementation class BoardViewPageController
 */
@WebServlet("/board/viewpage")
public class BoardViewPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardViewPageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Share0uDAO dao = new Share0uDAO();
		RecordVO vo = new RecordVO();

		//SESSION
		Object loginValue = request.getSession().getAttribute("login");
		Object mroleValue = request.getSession().getAttribute("mrole");


		String id = request.getParameter("rid");

		request.setAttribute("rid", id);

		try 
		{
			vo = dao.mypostView(id);

			request.setAttribute("title", vo.getRtitle());
			request.setAttribute("date", vo.getRegdate());
			request.setAttribute("writer", vo.getMid());
			request.setAttribute("contents", vo.getRcontent());
			request.setAttribute("point", vo.getRpoint());
			request.setAttribute("hits", vo.getRhits());
		 	//request.setAttribute("rid", vo.getRid());

		 // 내글 공유O

			if(mroleValue.toString().equals("y")) // 관리자 일때
			{
				if(loginValue.toString().equals(vo.getMid()) && vo.getRnotice().equals("y") )
				{
					
					request.setAttribute("noticecheck", "<input type = 'checkbox' value='y' name = 'check' checked> 공지여부");
				}
				else if(loginValue.toString().equals(vo.getMid()) && vo.getRnotice().equals("n") )
				{
					
					request.setAttribute("noticecheck", "<input type = 'checkbox' value='y' name = 'check'> 공지여부");
				}
			}
			else if(mroleValue.toString().equals("n")){
				if(loginValue.toString().equals(vo.getMid()) && vo.getRshare().equals("y") )
				{
					
					request.setAttribute("sharecheck", "<input type = 'checkbox' value='y' name = 'check' checked> 공유여부");
				}
				else if(loginValue.toString().equals(vo.getMid()) && vo.getRshare().equals("n") && vo.getRnotice().equals("n"))
				{
					
					request.setAttribute("sharecheck", "<input type = 'checkbox' value='y' name = 'check'> 공유여부");
				}
			}
			
			String modify ="<button onclick=\"location.href='/board/pagemodify?rid="+id+"'\">";
			String delete ="<button onclick=\"location.href='/board/pagedelete?rid="+id+"'\">";
			
			if(loginValue.toString().equals(vo.getMid()))
			{
				request.setAttribute("pagedelete", delete+"삭제</button>");
				request.setAttribute("pagemodify", modify+"수정</button>");
			}else{
				request.setAttribute("pagepoint", "<button>추천</button>");
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/WEB-INF/board/viewpage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
