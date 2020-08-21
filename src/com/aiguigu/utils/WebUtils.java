package com.aiguigu.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.aiguigu.bean.Cart;
import com.aiguigu.bean.User;

//web的相关工具
public class WebUtils {
	//传入request对象将request中的数据封装成对象
	public static<T> T param2bean(HttpServletRequest request,T t){
		
		//1.获取所有声明的属性
		Field[] fields=t.getClass().getDeclaredFields();
		//2.每个属性都有name值，属性名
		for(Field field:fields){
			//获取属性名
			String name=field.getName();
			//获取属性值
			String value=request.getParameter(name);
			try {
				BeanUtils.setProperty(t, name, value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return t;
	}
	
	public static<T> T param2bean2(HttpServletRequest request,T t){
		//pupulate将map中的键值对，直接映射到javaBean中
		Map map=request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("这里有错误：param2bean2");
			e.printStackTrace();
		}
		return t;
	}

	public static Cart getCart(HttpServletRequest request) {
		//购物车的整个内容Cart在session中保存
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
			//给session放入购物车
			session.setAttribute("cart", cart);
		}
		return cart;
	}
	
	public static User getLoginUser(HttpServletRequest request){
		//1.验证用户是否登录
		HttpSession session=request.getSession();
		//取出session中的用户
		return (User) session.getAttribute("user");
	}
	
	
}
