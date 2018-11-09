package com.blog.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.admin.service.IUserService;
import com.blog.model.JsonResult;
import com.blog.model.TUsers;

@Controller
@RequestMapping("/admin")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value= {"/login","/"})
	public String login() {
		return "/admin/page/login";
	}
	
	@RequestMapping(value="/toLogin")
	public JsonResult<Void> login(@RequestBody TUsers user){
		String code = userService.login(user);
		return new JsonResult<Void>(code, "0000".equals(code)?"登录成功":"账户名或密码错误");
	}
}
