package com.blog.admin.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
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
	public JsonResult<Void> toLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session){
		try {
			TUsers user = new TUsers();
			user.setUsername(username);
			user.setPassword(password);
			TUsers u = userService.login(user);
			u.setPassword(u.getPassword().replaceAll(".", "*"));
			session.setAttribute("admin", u);
		} catch (Exception e) {
			LOGGER.error("用户登录异常", e);
			new JsonResult<>("1111", "登录失败");
		}
		return new JsonResult<Void>("0000", "登录成功");
	}
	
	
}
