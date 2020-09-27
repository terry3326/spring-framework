package com.atguigu.ioc.userMod.service;

import com.atguigu.ioc.userMod.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	/*@Autowired
	@Qualifier(value="userDaoMybatisImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}*/
	
	@Override
	public void addUser() {
		userDao.addUser();
	}
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}
	
}
