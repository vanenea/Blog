package com.blog.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.admin.service.IBoardService;
import com.blog.model.JsonResult;

@Controller
@RequestMapping("/admin")
public class BoardController {
	
	@Autowired
	private IBoardService boardService;
	
	@RequestMapping(value="/boardInfor", method=RequestMethod.POST)
	@ResponseBody
	public JsonResult<Map<String,Object>> boardInfor(){
		Map<String, Object> boardInfor = boardService.boardInfor();
		return new JsonResult<>("0000", "查询仪表盘信息成功", boardInfor);
	}
}
