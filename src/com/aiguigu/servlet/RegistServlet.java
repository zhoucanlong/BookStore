package com.aiguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiguigu.bean.User;
import com.aiguigu.service.UserService;
import com.aiguigu.service.impl.UserServiceImpl;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		User user=new User(null,username,password,email);
		boolean b=us.regist(user);
		System.out.println(user.toString()+b);
		//用户注册
		if(b){
			//注册成功，返回成功页面，重定向
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else{
			//注册失败，返回注册页面重新注册，转发
			request.setAttribute("msg", "用户已存在");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
		
	}

}
