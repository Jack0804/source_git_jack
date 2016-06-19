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
 * Servlet implementation class BoardSharelistController
 */
@WebServlet("/board/sharelist")
public class BoardSharelistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSharelistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Share0uDAO dao = new Share0uDAO();
		List<RecordVO> list = null;
		
		String select = request.getParameter("select");
		String searchtext = request.getParameter("searchtext");
		
		if(select == null)	// sharelist 첫 화면
		{
			try 
			{
				list = dao.searchByFirst();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else if(select.equals("recommend"))
		{
			try 
			{
				list = dao.searchByRecommend(searchtext);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else if(select.equals("hits"))	// hits 추가해야합니다.
		{
			try 
			{
				list = dao.searchByHits(searchtext);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				list = dao.searchByRecent(searchtext);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
			
		request.setAttribute("search", list);
		request.getRequestDispatcher("/WEB-INF/board/sharelist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
