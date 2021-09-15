package com.sbs.java.am;

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
				Connection conn = null;

				try {
					conn = DriverManager.getConnection(url, user, password);
					DBUtil dbUtil = new DBUtil(request, response);

					int id = Integer.parseInt(request.getParameter("id"));
					
					// String.format을 사용하면 C언어의 printf처럼 사용가능
					String sql = String.format("SELECT * FROM article WHERE id = %d", id);
					Map<String, Object> articleRow = dbUtil.selectRow(conn, sql);

					response.getWriter().append(articleRow.toString());

					request.setAttribute("articleRow", articleRow);
					request.getRequestDispatcher("/jsp/home/detail.jsp").forward(request, response);

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			
	}

}
