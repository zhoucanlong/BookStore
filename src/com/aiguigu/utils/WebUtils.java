package com.aiguigu.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.aiguigu.bean.Cart;
import com.aiguigu.bean.User;

//web����ع���
public class WebUtils {
	//����request����request�е����ݷ�װ�ɶ���
	public static<T> T param2bean(HttpServletRequest request,T t){
		
		//1.��ȡ��������������
		Field[] fields=t.getClass().getDeclaredFields();
		//2.ÿ�����Զ���nameֵ��������
		for(Field field:fields){
			//��ȡ������
			String name=field.getName();
			//��ȡ����ֵ
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
		//pupulate��map�еļ�ֵ�ԣ�ֱ��ӳ�䵽javaBean��
		Map map=request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("�����д���param2bean2");
			e.printStackTrace();
		}
		return t;
	}

	public static Cart getCart(HttpServletRequest request) {
		//���ﳵ����������Cart��session�б���
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
			//��session���빺�ﳵ
			session.setAttribute("cart", cart);
		}
		return cart;
	}
	
	public static User getLoginUser(HttpServletRequest request){
		//1.��֤�û��Ƿ��¼
		HttpSession session=request.getSession();
		//ȡ��session�е��û�
		return (User) session.getAttribute("user");
	}
	
	
}
