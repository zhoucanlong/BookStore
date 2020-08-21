package com.aiguigu.test;

import java.sql.SQLException;

import com.aiguigu.bean.User;
import com.aiguigu.dao.UserDao;
import com.aiguigu.dao.impl.UserDaoImpl;

public class BaseDaoTest {
	public static void main(String[] args) throws SQLException{
		//UserDao ud=new UserDao();
		//String sql="select * from bs_user where id=1";
		//User bean=ud.getBean(sql, null);
		//System.out.println(bean);
		UserDao ud=new UserDaoImpl();
		User user=ud.getUserByUserNameAndPassWord(new User(null,"zhoucanlong","123456","2200789382@qq.com"));
		System.out.println(user.toString());
		boolean b=ud.registUser(new User(null,"yangzhou","123456","123456789@qq.com"));
		System.out.println(b);
	}
}
