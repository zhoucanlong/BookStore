package com.aiguigu.dao;
import com.aiguigu.bean.*;
public interface UserDao{
	//�����û������ѯ��ϸ��Ϣ
	public User getUserByUserNameAndPassWord(User user);
	//ע�ᱣ���û�
	public boolean registUser(User user);
	
	public User getUserByUserName(User user);
}
