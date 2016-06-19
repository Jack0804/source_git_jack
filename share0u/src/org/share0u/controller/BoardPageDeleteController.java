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
 * Servlet implementation class BoardPageDeleteController
 */
@WebServlet("/board/pagedelete")
public class BoardPageDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPageDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Share0uDAO dao = new Share0uDAO();
		RecordVO 	vo = new RecordVO();
		
		System.out.println("attribute = " + request.getAttribute("rid"));
		System.out.println("parameter = " + request.getParameter("rid"));
		
		String rid = (String)request.getParameter("rid");
		
		System.out.println("rid = "+rid);
		dao.deleteRecord(rid);
		
		response.sendRedirect("/board/mylist");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
