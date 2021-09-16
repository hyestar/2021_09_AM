package com.sbs.java.am.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.java.am.util.DBUtil;
import com.sbs.java.am.util.SecSql;

@WebServlet("/article/detail")
public class ArticleDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String url = "jdbc:mysql://localhost:3306/am?serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeBehavior=convertToNull";
		String user = "root";
		String password = "";
		// 커넥터 드라이버 활성화
				String driverName = "com.mysql.cj.jdbc.Driver";

				try {
					Class.forName(driverName);
				} catch (ClassNotFoundException e) {
					System.err.printf("[ClassNotFoundException 예외, %s]\n", e.getMessage());
					response.getWriter().append("DB 드라이버 클래스 로딩 실패");
					return;
				}

				// DB 연결
				Connection con = null;

				try {
					con = DriverManager.getConnection(url, user, password);

					int id = Integer.parseInt(request.getParameter("id"));
					
					// String.format을 사용하면 C언어의 printf처럼 사용가능
					SecSql sql = SecSql.from("SELECT * ");
					sql.append("FROM article");
					sql.append("WHERE id = ?", id);
					Map<String, Object> articleRow = DBUtil.selectRow(con, sql);

					response.getWriter().append(articleRow.toString());

					request.setAttribute("articleRow", articleRow);
					request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			
	}

}
