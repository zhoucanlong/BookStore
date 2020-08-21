package com.aiguigu.dao;
import com.aiguigu.bean.*;
public interface UserDao{
	//按照用户密码查询详细信息
	public User getUserByUserNameAndPassWord(User user);
	//注册保存用户
	public boolean registUser(User user);
	
	public User getUserByUserName(User user);
}
