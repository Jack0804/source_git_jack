package org.share0u.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class Share0uFilter
 */
@WebFilter({"/board/mylist","/board/sharelist","/board/register"})
public class Share0uFilter implements Filter {

    /**
     * Default constructor. 
     */
    public Share0uFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request   = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
				
		// Sessio에 login 이라는 이름의 값이 뭔가 있는지 확인.
		Object loginValue = request.getSession().getAttribute("login");
		Object mroleValue = request.getSession().getAttribute("mrole");
		
		System.out.println("LOGINVALUE : " + loginValue);
		
		if(loginValue == null)
		{
			response.sendRedirect("/member/login");
			return;
		}
		
		chain.doFilter(req, res);	// 마지막의 여기 소스는 반드시 남겨주어야한다.
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}

}
