package com.blog.admin.controller;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.admin.service.IBoardService;
import com.blog.model.JsonResult;
import com.blog.model.TContents;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/admin")
public class BoardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IBoardService boardService;
	
	@RequestMapping(value="/boardInfor", method=RequestMethod.POST)
	public JsonResult<Map<String,Object>> boardInfor(){
		Map<String, Object> boardInfor = boardService.boardInfor();
		return new JsonResult<>("0000", "查询仪表盘信息成功", boardInfor);
	}
	
	@PostMapping(value="/insertArticle",consumes="application/x-www-form-urlencoded;charset=UTF-8")
	public JsonResult<Void> insertArticle(String title, String status, String tag,
			String categories, boolean allowComment,
			boolean allowPing, boolean allowFeed, String content){
		try {
			TContents contents = new TContents();
			contents.setTitle(title);
			contents.setStatus(status);
			contents.setTags(tag);
			contents.setCategories(categories);
			contents.setAllowComment(allowComment);
			contents.setAllowPing(allowPing);
			contents.setAllowFeed(allowFeed);
			contents.setContent(content);
			int modified = (int) (new Date().getTime()/1000);
			contents.setModified(modified);
			contents.setType("post");
			boardService.insertArticle(contents);
		} catch (Exception e) {
			return new JsonResult<>("1111", "添加文章失败");
		}
		return new JsonResult<>("0000", "添加文章成功");
	}
	
	@GetMapping("/articleList")
	@ResponseBody
	public JsonResult<PageInfo<TContents>> contentsList(int pageNum, int pageSize){
		try {
			PageInfo<TContents> articleList = boardService.articleList(pageNum, pageSize);
			return new JsonResult<>("0000", "查询文章成功", articleList);
		} catch (Exception e) {
			LOGGER.error("查询文章失败", e);
			return new JsonResult<>("1111", "查询文章失败");
		}
		
	}
	
}
