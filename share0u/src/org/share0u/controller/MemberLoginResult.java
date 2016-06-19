package org.share0u.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.share0u.dao.Share0uDAO;
import org.share0u.domain.MemberVO;

/**
 * Servlet implementation class MemberLoginResult
 */
@WebServlet("/member/loginresult")
public class MemberLoginResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/member/login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Share0uDAO dao = new Share0uDAO();
		MemberVO   vo  = new MemberVO();
		
		vo.setMid(request.getParameter("id"));
		vo.setMpw(request.getParameter("pw"));
	
		boolean loginCheck = dao.memberLogin(vo);
		
		if(loginCheck==true)
		{
			vo = dao.memberValue(vo);
			request.setAttribute("msg", vo.getMid());
			
			HttpSession	session = request.getSession(); 	
			session.setAttribute("login",  vo.getMid());
			session.setAttribute("mrole", vo.getMrole());
			
			response.sendRedirect("/board/mylist");
		}
		else
		{
			response.sendRedirect("/member/login");
			return;
		}
	}

}
