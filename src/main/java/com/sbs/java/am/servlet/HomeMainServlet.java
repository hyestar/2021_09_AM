package com.sbs.java.am.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home/main")
public class HomeMainServlet extends HttpServlet {
	
	// 서블릿에서 세션 사용하는 방법 HttpServletRequest 파라미터에 대해 getSession 메서드를 호출
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 세션 생성
		HttpSession session = request.getSession();
		boolean islogined = false;
		int loginedMemberId = -1;
		
		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
			islogined = true;
		}
		
		request.setAttribute("isLogined", islogined);
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.getRequestDispatcher("/jsp/home/main.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
