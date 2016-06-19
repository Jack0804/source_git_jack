package org.share0u.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.share0u.dao.Share0uDAO;
import org.share0u.domain.MemberVO;

/**
 * Servlet implementation class ResultController
 */
@WebServlet("/member/result")
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultController() {
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
		
		MemberVO	vo = new MemberVO();
		Share0uDAO dao = new Share0uDAO();
		
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo.setMrole(request.getParameter("mrole"));
		vo.setMname(request.getParameter("mname"));
		
		try 
		{
			dao.memberInsert(vo);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("/member/login");
	}

}
