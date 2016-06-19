package org.share0u.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.share0u.domain.RecordVO;

/**
 * Servlet implementation class BoardRegisterController
 */
@WebServlet("/board/register")
public class BoardRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Object mrole = request.getSession().getAttribute("mrole");
		Object mid 	 = request.getSession().getAttribute("login");
		
		String role = (String) mrole;
		String msg = null;
		
		if(role.equals("y"))	// 관리자 일 때,
		{
			request.setAttribute("noticecheck", "<input type = 'checkbox' value='y' name = 'noticecheck'> 공지");
		}
		else // 학생일 때,
		{
			request.setAttribute("sharecheck", "<input type = 'checkbox' value='y' name = 'sharecheck'> 공유");
		}
		
		request.getRequestDispatcher("/WEB-INF/board/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
