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

/**
 * Servlet Filter implementation class FlowFiterOne
 */ 
//@WebFilter(urlPatterns= {"/member/*"}, servletNames="SelectDeptListServ", filterName="flow3")
//urlPatterns으로 지정할 수 있고 이것만 있으면 생략이 가능함("/member/*)
//servletNames으로 지정할 수 있다.(해당 하는 서블릿 이름명으로 지정해주면 됨)
//"/"은 모든 servlet을 시작할 때 필터를 적용한다는 뜻
//filterName은 등록하려고 하는 필터의 이름을 지정할 수 있다.
public class FlowFiterOne implements Filter {
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter() 호출 전 ...........one");
		chain.doFilter(request, response); //서블릿
		System.out.println("doFilter() 호출 후 ...........one");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init() 호출 ...........one");
	}

}
