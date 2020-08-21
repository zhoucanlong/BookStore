package com.aiguigu.dao.impl;

import java.sql.SQLException;

import com.aiguigu.bean.User;
import com.aiguigu.dao.BaseDao;
import com.aiguigu.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUserByUserNameAndPassWord(User user){
		String sql="select * from bs_user where username=? and password=?";
		User bean=null;
		try {
			bean = this.getBean(sql, user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public boolean registUser(User user) {
		String sql="insert into bs_user(username,password,email) value(?,?,?)";
		int update=0;
		try {
			update = this.update(sql, user.getUsername(),user.getPassword(),user.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return update>0;
	}

	@Override
	public User getUserByUserName(User user) {
		// TODO Auto-generated method stub
		String sql="select * from bs_user where username=?";
		User u=null;
		try {
			u=getBean(sql,user.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
