package org.share0u.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.share0u.dao.Share0uDAO;
import org.share0u.domain.RecordVO;

/**
 * Servlet implementation class BoardPageModifyController
 */
@WebServlet("/board/pagemodify")
public class BoardPageModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPageModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Share0uDAO dao = new Share0uDAO();
		RecordVO	vo = new RecordVO();
		
		String rid = request.getParameter("rid");
		System.out.println("rid = "+rid);
		
		Object loginValue = request.getSession().getAttribute("login");
		Object mroleValue = request.getSession().getAttribute("mrole");

		try 
		{
			vo = dao.mypostView(rid);
			
			request.setAttribute("rshare", 	vo.getRshare());
			request.setAttribute("rnotice", vo.getRnotice());
			
			System.out.println(vo.toString());
			request.setAttribute("title", 		vo.getRtitle());
			request.setAttribute("contents",	vo.getRcontent());
			request.setAttribute("check", 		vo.getRshare());
			request.setAttribute("rid", rid);
			
	
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		if (mroleValue.toString().equals("y")) // 관리자 일때
		{	
		 // 공지가 체크되어있을 때,
			if (vo.getRnotice().equals("y")) 
			{
				request.setAttribute("noticecheck", "<input type = 'checkbox' value='y' name = 'noticecheck' checked> 공지여부");
			}
		 // 공지가 체크 안되어있을 때,	
			else if(vo.getRnotice().equals("n")) 
			{
				request.setAttribute("noticecheck", "<input type = 'checkbox' value='y' name = 'noticecheck'> 공지여부");
			}
		} 
		else if (mroleValue.toString().equals("n"))	// 관리자가 아닐 때, 
		{
		 // 공유가 "Y"일때,	
			if (vo.getRshare().equals("y")) 
			{
				
				request.setAttribute("sharecheck", "<input type = 'checkbox' value='y' name = 'sharecheck' checked> 공유여부");
				
			}
		 // 공유가 "N"일때,	
			else if (vo.getRshare().equals("n"))
			{
			
				request.setAttribute("sharecheck", "<input type = 'checkbox' value='y' name = 'sharecheck'> 공유여부");
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/board/modifypage.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
