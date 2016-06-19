package org.share0u.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.share0u.dao.Share0uDAO;
import org.share0u.domain.MemberVO;
import org.share0u.domain.RecordVO;

/**
 * Servlet implementation class BoardResultController
 */
@WebServlet("/board/resultmylist")
public class BoardResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		RecordVO	vo = new RecordVO();
		Share0uDAO dao = new Share0uDAO();

		Object value = request.getSession().getAttribute("login");
		
		vo.setMid((String)value);
		vo.setRtitle(request.getParameter("title"));
		vo.setRcontent(request.getParameter("contents"));
		
		if ( request.getParameter("noticecheck") != null)	// noticecheck(공지글이다)
		{
			vo.setRnotice("y");
		}
		else
		{
			vo.setRnotice("n");
		}
		
		if ( request.getParameter("sharecheck") != null)	// noticecheck(공지글이다)
		{
			vo.setRshare("y");
		}
		else
		{
			vo.setRshare("n");
		}
		
		try 
		{
			dao.mylistInsert(vo);
			response.sendRedirect("/board/mylist");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
