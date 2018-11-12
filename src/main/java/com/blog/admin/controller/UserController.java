package com.blog.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.admin.service.IUserService;
import com.blog.model.JsonResult;
import com.blog.model.TUsers;

@Controller
@RequestMapping("/admin")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 登录页
	 * @return
	 */
	@RequestMapping(value= {"/login",""})
	public String login() {
		return "/admin/page/login";
	}
	
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "/admin/page/index";
	}
	
	@RequestMapping(value="/toLogin",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult<Void> toLogin(@RequestParam("username") String username, @RequestParam("password") String password){
		TUsers user = new TUsers();
		user.setUsername(username);
		user.setPassword(password);
		String code = userService.login(user);
		return new JsonResult<Void>(code, "0000".equals(code)?"登录成功":"账户名或密码错误");
	}
}
