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
		//在这里解决乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//处理用户请求login --UserServlet  regist--UserServlet
		String method=request.getParameter("method");
		try {
			Method method2=this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//把方法权限设大
			method2.setAccessible(true);
			//invoke(对象，参数);
			method2.invoke(this, request,response);
		} catch (Exception e) {
			System.out.println("invoke异常");
			e.printStackTrace();
		} 
	}

}
