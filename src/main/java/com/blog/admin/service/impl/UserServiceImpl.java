package com.blog.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.admin.service.IUserService;
import com.blog.mapper.TUsersMapper;
import com.blog.model.TUsers;
import com.blog.model.TUsersExample;
import com.blog.model.TUsersExample.Criteria;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private TUsersMapper usersMapper;
	
	@Override
	public TUsers findUserByUsername(String username) {
		TUsersExample example = new TUsersExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameNotEqualTo(username);
		List<TUsers> list = usersMapper.selectByExample(example);
		if(list!=null && list.size()==1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public String login(TUsers user) {
		String username = user.getUsername();
		if(username!=null) {
			TUsers u = findUserByUsername(username);
			if(u!=null && u.getPassword().equals(user.getPassword())) {
				return "0000";
			} 
		}
		return "1111";
	}

	
}
