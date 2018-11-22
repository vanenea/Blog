package com.blog.admin.service;

import java.util.List;
import java.util.Map;

import com.blog.model.TContents;
import com.github.pagehelper.PageInfo;

public interface IBoardService {
	/**
	 *仪表盘信息
	 * @return
	 */
	Map<String, Object> boardInfor();
	
	void insertArticle(TContents contents);
	
	PageInfo<TContents> articleList(int pageNum, int pageSize);
}
