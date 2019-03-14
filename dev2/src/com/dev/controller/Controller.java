package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * 컨트롤러 인터페이스 정의
 * execute()메소드는 모든 Controller 클래스들을 재정의하면서 다형성 제공
 */
public interface Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
