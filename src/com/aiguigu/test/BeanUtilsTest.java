package com.aiguigu.test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.aiguigu.bean.User;

public class BeanUtilsTest {
	public static void main(String[] args){
		//setProperty(bean, name, value);
		//bean����Ҫ���ĸ�������������ֵ
		//name����Ҫ���õ�������
		//valueҪ���õ�ֵ
		User user=new User();
		System.out.println("����֮ǰ��"+user);
		try {
			BeanUtils.setProperty(user,"username","zhoucanlong");
			System.out.println("����֮��"+user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
