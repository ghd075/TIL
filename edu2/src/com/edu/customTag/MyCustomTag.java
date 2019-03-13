package com.edu.customTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
/*
 * 태그로 사용될 클래스 => 태그 핸들러
 */
public class MyCustomTag extends TagSupport {
	
	private String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("끝 태그를 만났습니다.");
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("시작 태그를 만났습니다.");
		System.out.println("color 속성 : " + color);
		return super.doStartTag();
	}
	
}
