package com.sbs.java.am.servlet;

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

import com.sbs.java.am.util.DBUtil;
import com.sbs.java.am.util.SecSql;

@WebServlet("/article/list")
public class ArticleListServlet extends HttpServlet {
	@Override
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
					
					int itemslnAPage = 20;
					
					int page=1;
					if(request.getParameter("page")!=null && request.getParameter("page").length() != 0) {
						try {
						page = Integer.parseInt(request.getParameter("page"));
						}
						catch(NumberFormatException e) {
							
						}
					}
					int limitFrom = (page-1)*itemslnAPage;

					SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt");
					sql.append("FROM article");
					int totalCount = DBUtil.selectRowIntValue(con, sql);
					
					int totalpage = (int)Math.ceil((double)totalCount/itemslnAPage);

					sql = SecSql.from("SELECT *");
					sql.append("FROM article");
					sql.append("ORDER BY id DESC limit ?, ?", limitFrom, itemslnAPage);

					System.out.println(sql);
					List<Map<String, Object>> articleRows = DBUtil.selectRows(con, sql);

					response.getWriter().append(articleRows.toString());

					request.setAttribute("articleRows", articleRows);
					request.setAttribute("page", page);
					request.setAttribute("totalpage", totalpage);
					request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);

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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
