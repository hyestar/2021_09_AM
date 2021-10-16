package com.sbs.java.am.service;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.sbs.java.am.dao.ArticleDao;
import com.sbs.java.am.util.DBUtil;
import com.sbs.java.am.util.SecSql;

public class ArticleService {
	private Connection con;
	private ArticleDao articleDao;

	public ArticleService(Connection con) {
		this.con = con;
		this.articleDao = new ArticleDao(con);
	}

	public int getItemsInAPage() {
		return 3;
	}

	public int getForPrintListTotalPage() {
		int itemsInAPage = getItemsInAPage();

		int totalCount = articleDao.getTotalCount();
		int totalpage = (int) Math.ceil((double) totalCount / itemsInAPage);

		return totalpage;
	}

	public List<Map<String, Object>> getForPrintArticleRows(int page) {
		int itemsInAPage = getItemsInAPage();
		int limitFrom = (page - 1) * itemsInAPage;

		List<Map<String, Object>> articleRows = articleDao.getArticleRows(limitFrom, itemsInAPage);

		return articleRows;
	}

}