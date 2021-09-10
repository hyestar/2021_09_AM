package com.sbs.java.am;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home/printDan")
public class HomePrintDanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String inputedDan = request.getParameter("dan");
		
		if(inputedDan == null) {
			inputedDan = "1";
		}
		
		String inputedlimit = request.getParameter("limit");
		
		if(inputedlimit == null) {
			inputedlimit = "1";
		}
		
		String inputedcolor = request.getParameter("color");
		if(inputedcolor == null) {
			inputedcolor = "black";
		}
		
		String backcolor = request.getParameter("backcolor");
		// html 형태이기에 \n은 인식하지 못하므로 <br>로 처리해줘야 한다.
		// ctrl + e 자동완성기능
		int dan =  Integer.parseInt(inputedDan);
		int limit =  Integer.parseInt(inputedlimit);

		response.getWriter().append(String.format("<div>%d단<div>", dan));
		for(int i = 1; i<=limit; i++) {
			response.getWriter().append(String.format("<div style = 'color : %s; background-color : %s;'> %d * %d = %d <div>", inputedcolor, backcolor, dan, i, dan*i));
		}
	}

}
