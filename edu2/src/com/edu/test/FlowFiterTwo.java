package com.edu.test;

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

public class FlowFiterTwo implements Filter {
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter() 호출 전 ...........two");
		//로그인, 회원가입
		String uri = ((HttpServletRequest)request).getRequestURI();
		if(!(uri.indexOf("login")>=0) && !(uri.indexOf("insertMember") >= 0)) {
			
			if(true) {
				
			}else {
				chain.doFilter(request, response); // 서블릿
			}
		}
		// 로그인 여부 체크
		// HttpServle로 업캐스팅해줘야 세션에 저장된 userid 속성을 읽어서 NULL값이면
		if (((HttpServletRequest) request).getSession().getAttribute("userid") == null) {
			//login.jsp로 sendRedirect방식으로 넘겨줘라
			((HttpServletResponse) response).sendRedirect("/edu2/member/login.jsp");
		} else { //NULL값아니면 로그인이 되었기 때문에
			//필터링에 설정된 서블릿을 실행해라(filter-mapping가 갖고 있는 정보를 순서대로 실행)
			chain.doFilter(request, response); // 서블릿
		}

		System.out.println("doFilter() 호출 후 ...........two");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init() 호출 ...........two");
	}
}
