package com.sbs.java.am.service;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.sbs.java.am.util.DBUtil;
import com.sbs.java.am.util.SecSql;

public class ArticleService {
	private Connection con;

	public ArticleService(Connection con) {
		this.con = con;
	}

	public int getItemsInAPage() {
		return 3;
	}

	public int getForPrintListTotalPage() {
		int itemsInAPage = getItemsInAPage();

		SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt");
		sql.append("FROM article;");
		int totalCount = DBUtil.selectRowIntValue(con, sql);
		int totalpage = (int) Math.ceil((double) totalCount / itemsInAPage);

		return totalpage;
	}

	public List<Map<String, Object>> getForPrintArticleRows(int page) {
		int itemsInAPage = getItemsInAPage();
		int limitFrom = (page - 1) * itemsInAPage;

		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM article");
		sql.append("ORDER BY id DESC");
		sql.append("LIMIT ?, ?", limitFrom, itemsInAPage);

		List<Map<String, Object>> articleRows = DBUtil.selectRows(con, sql);

		return articleRows;
	}

}