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
		System.out.println("filter������");
		//��֤�û��Ƿ��¼�������¼����У�����ת����¼ҳ��
		HttpServletRequest req=(HttpServletRequest) request;
		//��ȡ�Ѿ���¼���û�
		User user=WebUtils.getLoginUser(req);
		if(user==null){
			//δ��¼
			request.setAttribute("msg", "�˲�����Ҫ��¼�����ȵ�¼");
			request.getRequestDispatcher("/pages/user/login.jsp");
		}else{
			//�ѵ�¼
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
