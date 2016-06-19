package org.share0u.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.share0u.dao.Share0uDAO;
import org.share0u.domain.MemberVO;
import org.share0u.domain.RecordVO;

/**
 * Servlet implementation class MylistCotroller
 */
@WebServlet("/board/mylist")
public class BoardMylistCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardMylistCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		doPost(request, response);
	 // request.getRequestDispatcher("/WEB-INF/board/mylist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = null;
		String pagelist = "";
		Share0uDAO dao = new Share0uDAO();
		MemberVO vo = new MemberVO();
		int page = 1;
		List<RecordVO> list, myList;
		Object loginValue = request.getSession().getAttribute("login");	
		
		String msg = loginValue.toString();
		String pagestring = request.getParameter("page");
		
		if ( pagestring == null){
			page = 1;
		}else{
			page = Integer.parseInt(pagestring);
		}
		
		try 
		{
			int recordCount = dao.findRecordNumber(loginValue.toString());
			
			int count = (int)Math.ceil((double)recordCount / 10);
			System.out.println("count"+count);
			
			for(int i=1; i<=count;i++){
				pagelist = pagelist+"<a href='/board/mylist?page="+i+"'>["+ i +"]</a>";
			}
			
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
		
		try 
		{
			list = dao.noticeRead();
			request.setAttribute("result", list);
			
			myList = dao.myRead2(loginValue.toString(), page);
			request.setAttribute("myresult", myList);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("pagelist", pagelist);
		request.getRequestDispatcher("/WEB-INF/board/mylist.jsp").forward(request, response);	
	}

}
