package com.edu.customTag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyCustomTag2 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspContext context = this.getJspContext();
		JspWriter out = context.getOut();
		StringWriter sw = new StringWriter();
		this.getJspBody().invoke(sw);
		String body = sw.toString();
		
		out.print("<table border='1'><tr><td>" + body);
		out.print("</td></tr></table>");
		/*
		 * System.out.println("커스텀 태그의 바디가 실행되기 전"); this.getJspBody().invoke(null);
		 * System.out.println("커스텀 태그의 바디가 실행된 후");
		 */
	}
	
}
