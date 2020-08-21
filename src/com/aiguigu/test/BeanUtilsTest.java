package com.aiguigu.test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.aiguigu.bean.User;

public class BeanUtilsTest {
	public static void main(String[] args){
		//setProperty(bean, name, value);
		//bean代表要给哪个对象设置属性值
		//name代表要设置的属性名
		//value要设置的值
		User user=new User();
		System.out.println("设置之前："+user);
		try {
			BeanUtils.setProperty(user,"username","zhoucanlong");
			System.out.println("设置之后："+user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
