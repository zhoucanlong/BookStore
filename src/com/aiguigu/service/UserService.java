package com.aiguigu.service;

import com.aiguigu.bean.User;
//����û���¼ע��
public interface UserService {
	public User login(User user);
	public boolean regist(User user);
	public boolean checkuser(User user);
}
