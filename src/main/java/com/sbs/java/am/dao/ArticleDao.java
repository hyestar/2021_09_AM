package com.sbs.java.am.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.sbs.java.am.util.DBUtil;
import com.sbs.java.am.util.SecSql;

public class ArticleDao {
	private Connection con;

	public ArticleDao(Connection con) {
		this.con = con;
	}

	public int getTotalCount() {
		SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt");
		sql.append("FROM article;");
		int totalCount = DBUtil.selectRowIntValue(con, sql);

		return totalCount;
	}

	public List<Map<String, Object>> getArticleRows(int limitFrom, int limitCount) {
		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM article");
		sql.append("ORDER BY id DESC");
		sql.append("LIMIT ?, ?", limitFrom, limitCount);

		List<Map<String, Object>> articleRows = DBUtil.selectRows(con, sql);

		return articleRows;
	}
}
