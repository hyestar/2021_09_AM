package com.sbs.java.am;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/article/list")
public class ArticleListServlet extends HttpServlet {
	
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

					String sql = "SELECT * FROM article";
					List<Map<String, Object>> articleRows = dbUtil.selectRows(conn, sql);

					response.getWriter().append(articleRows.toString());

					request.setAttribute("articleRows", articleRows);
					request.getRequestDispatcher("/jsp/home/list.jsp").forward(request, response);

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
