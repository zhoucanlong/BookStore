package com.aiguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BaseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//�����û�����login --UserServlet  regist--UserServlet
		String method=request.getParameter("method");
		try {
			Method method2=this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//�ѷ���Ȩ�����
			method2.setAccessible(true);
			//invoke(���󣬲���);
			method2.invoke(this, request,response);
		} catch (Exception e) {
			System.out.println("invoke�쳣");
			e.printStackTrace();
		} 
	}

}
