package com.aiguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aiguigu.bean.User;
import com.aiguigu.service.UserService;
import com.aiguigu.service.impl.UserServiceImpl;
import com.aiguigu.utils.WebUtils;
import com.google.code.kaptcha.Constants;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
	public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user2=WebUtils.param2bean(request, new User());
		User user=us.login(user2);
		//将用户保存到session中
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		if(user==null){
			//登录失败
			request.setAttribute("msg", "用户名错误");
			//设置上要回显的项目
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			//登录成功
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		User user=new User(null,username,password,email);
		//页面验证码
		String code=request.getParameter("code");
		HttpSession session=request.getSession();
		String sessionCode=(String) session.getAttribute(Constants.KAPTCHA_SESSION_CONFIG_KEY);
		//如果验证码一致，则注册，否则回到注册页面并提示验证码错误
		if(!sessionCode.equals(code)){
			//验证码相同
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/page/user/regist.jsp").forward(request, response);
			return;
		}
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
	//用户登出操作
	protected void logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//销毁session
		session.invalidate();
		//返回商城首页
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	protected void checkuser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//页面应该把用户名传过来   key应该是username
		User user=WebUtils.param2bean(request, new User());
		//检查用户是否可用
		boolean b=us.checkuser(user);
		if(b){
			//可以注册,写数据就是给客户端响应
			response.getWriter().write("用户名可用");
		}else{
			response.getWriter().write("用户名已被占用");
		}
	}
	
	
}
