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
import javax.servlet.http.HttpSession;

import com.sbs.java.am.Config;
import com.sbs.java.am.exception.SQLErrorException;
import com.sbs.java.am.util.DBUtil;
import com.sbs.java.am.util.SecSql;

@WebServlet("/member/dologin")
public class MemberDologinServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		String driverName = Config.getDBDriverClassName();

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
			con = DriverManager.getConnection(Config.getDBUrl(), Config.getDBId(), Config.getDBPw());
			String loginId = request.getParameter("loginId");
			String loginPw = request.getParameter("loginPw");
			
			SecSql sql = SecSql.from("SELECT *");
			sql.append("FROM `member`");
			sql.append("WHERE loginId = ?", loginId);

			Map<String,Object> memberRow = DBUtil.selectRow(con, sql);

			if(memberRow.isEmpty()) {
				response.getWriter().append(
						String.format("<script> alert('%s (은)는 존재하지 않는 회원입니다.'); history.back(); </script>", loginId));
				return;
			}

			if( ((String)memberRow.get("loginPw")).equals(loginPw) == false) {
				response.getWriter().append(
						String.format("<script> alert('비밀번호가 일치하지 않습니다.'); history.back(); </script>", loginId));
				return;
			}

			HttpSession session =  request.getSession();
			session.setAttribute("loginedMemberId", memberRow.get("id"));

			response.getWriter().append(
					String.format("<script> alert('로그인 성공!'); location.replace('../home/main'); </script>", loginId));
			return;

			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SQLErrorException e) {
			e.getOrigin().printStackTrace();
		}  finally {
			if(con!=null) {
				try {
					con.close();
			} catch(SQLException e) {
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