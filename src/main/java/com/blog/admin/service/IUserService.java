package com.blog.admin.service;

import com.blog.model.TUsers;

public interface IUserService {

	/**
	 * 通过用户名找到用户
	 * @param username
	 * @return
	 */
	TUsers findUserByUsername(String username);
	
	/**
	 * 登录操作
	 * @param user
	 * @return
	 */
	TUsers login(TUsers user);
}
