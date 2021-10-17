package com.sbs.java.am.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.java.am.dto.Article;
import com.sbs.java.am.service.ArticleService;

public class ArticleController {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private Connection con;
	private ArticleService articleService;

	public ArticleController(HttpServletRequest request, HttpServletResponse response, Connection con) {
		this.request = request;
		this.response = response;
		articleService = new ArticleService(con);
	}

	public void actionList() throws ServletException, IOException {
		int page = 1;

		if (request.getParameter("page") != null && request.getParameter("page").length() != 0) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		int totalpage = articleService.getForPrintListTotalPage();
		List<Article> articles = articleService.getForPrintArticles(page);

		request.setAttribute("articles", articles);
		request.setAttribute("page", page);
		request.setAttribute("totalpage", totalpage);
		request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);
	}

}
