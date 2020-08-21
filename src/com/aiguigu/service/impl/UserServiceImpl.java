package com.aiguigu.service.impl;

import com.aiguigu.bean.User;
import com.aiguigu.dao.UserDao;
import com.aiguigu.dao.impl.UserDaoImpl;
import com.aiguigu.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao ud=new UserDaoImpl();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return ud.getUserByUserNameAndPassWord(user);
	}
	@Override
	public boolean regist(User user) {
		// TODO Auto-generated method stub
		return ud.registUser(user);
	}
	/**
	 * ���ؽ��
	 * true ����ע��
	 * false  �û��Ѵ���
	 */
	@Override
	public boolean checkuser(User user) {
		// TODO Auto-generated method stub
		User byUserName=ud.getUserByUserName(user);
		return byUserName==null;
	}
}
