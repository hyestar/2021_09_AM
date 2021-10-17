package com.sbs.java.am.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class Article {
	public int id;
	public LocalDateTime regDate;
	public String title;
	public String body;
	public int memberId;

	public Article() {

	}

	public Article(Map<String,Object> row){
		this.id = (int)row.get("id");
		this.regDate = (LocalDateTime)row.get("regDate");
		this.title = (String)row.get("title");
		this.body = (String)row.get("body");
		this.memberId = (int)row.get("memberId");
	}
}
