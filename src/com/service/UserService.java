package com.service;

import java.sql.SQLException;

import com.dao.UserDao;
import com.doman.User;

public class UserService {
	private UserDao userDao=new UserDao();

	//ע�Ṧ��
	public Boolean register(User user) throws ClassNotFoundException, SQLException {
	User u=userDao.findByUsername(user.getUsername());
	if (u==null){
		userDao.add(user);
		return true;
	}else{
		return false;
	}
	
	}

}
