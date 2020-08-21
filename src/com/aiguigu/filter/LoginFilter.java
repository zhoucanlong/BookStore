package com.aiguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.aiguigu.bean.User;
import com.aiguigu.utils.WebUtils;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter已启动");
		//验证用户是否登录，如果登录则放行，否则转到登录页面
		HttpServletRequest req=(HttpServletRequest) request;
		//获取已经登录的用户
		User user=WebUtils.getLoginUser(req);
		if(user==null){
			//未登录
			request.setAttribute("msg", "此操作需要登录，请先登录");
			request.getRequestDispatcher("/pages/user/login.jsp");
		}else{
			//已登录
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
